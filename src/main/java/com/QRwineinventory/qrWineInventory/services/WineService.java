package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.exceptions.InvalidSellingQuantity;
import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.repositories.WineRepository;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class WineService implements WebMvcConfigurer {

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/pictures/**")
                .addResourceLocations("/pictures/")
                .addResourceLocations("classpath:/pictures/");
    }

    public void createQR(String data, String filename, String charset, Map hashMap, int height, int width) throws WriterException, IOException
    {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToFile(
                matrix,
                filename.substring(filename.lastIndexOf('.') + 1),
                new File("src/main/resources/pictures/"+filename));
    }
    public void insertWine(Wine wine, @Null UUID preMadeUID) throws WriterException, IOException {
        UUID uid = UUID.randomUUID();
        if (preMadeUID != null) uid = preMadeUID;
        wine.setUid(uid);
        String data = "http://localhost:8080/inventory/wine?id="+uid;
        String path = "QR-"+ uid +".png";
        String charset = "UTF-8";
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // Create the QR code and save
        // in the specified folder
        createQR(data, path, charset, hashMap, 200, 200);
        wine.setImage_pp(path);
        wineRepository.save(wine);
    }

    public List<Wine> getAllWine(String keyword) {
        if (keyword != null) {
            return wineRepository.search(keyword);
        }
        return wineRepository.findAll();
    }

    public Page<Wine> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.wineRepository.findAll(pageable);
    }

    public Optional<Wine> getWineById(UUID id) {
        return wineRepository.findById(id);
    }

    public boolean deleteWineById(UUID id) {
        Path root = Paths.get("/src/main/resources/pictures");
        Optional<Wine> wineFound = getWineById(id);
        Wine wine;
        String filename = "";
        if (wineFound.isPresent())
        {
            wine = wineFound.get();
            filename = wine.getImage_pp();
        }
        wineRepository.deleteById(id);
        try {
            Path file = root.resolve(filename);
            System.out.println("deleting: "+ file);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            System.out.println("Filename might be empty because no wine has been found with this uID");
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void sellWine(UUID wineId, Wine sellingWine) throws InvalidSellingQuantity {
        if (sellingWine.getQuantity() > 0) {
            Wine newWineToDB;
            Optional<Wine> wineFromDB = wineRepository.findById(wineId);
            if (wineFromDB.isPresent()) {
                newWineToDB = wineFromDB.get();
                if (sellingWine.getQuantity() > newWineToDB.getQuantity()) {
                    throw new InvalidSellingQuantity("Requested quantity to sell is too big");
                }
                newWineToDB.setQuantity(newWineToDB.getQuantity() - sellingWine.getQuantity());

                wineRepository.save(newWineToDB);
            }
        }
    }

    public void restockWine(UUID wineId, Wine restockingWine) throws InvalidSellingQuantity {
        if (restockingWine.getQuantity() > 0) {
            Wine newWineToDB;
            Optional<Wine> wineFromDB = wineRepository.findById(wineId);
            if (wineFromDB.isPresent()) {
                newWineToDB = wineFromDB.get();
                newWineToDB.setQuantity(newWineToDB.getQuantity() + restockingWine.getQuantity());
                wineRepository.save(newWineToDB);
            }
        }
    }

    public void updateWine(UUID wineId, Wine wine)
    {
        Wine newWineToDB = new Wine();
        Optional<Wine> wineFromDB = wineRepository.findById(wineId);
        if (wineFromDB.isPresent()) {
               newWineToDB = wineFromDB.get();
        }

        if (Objects.nonNull(wine.getBrand_grape())
                && !"".equalsIgnoreCase(
                wine.getBrand_grape())) {
            newWineToDB.setBrand_grape(
                    wine.getBrand_grape());
        }

        if (Objects.nonNull(
                wine.getWinery())
                && !"".equalsIgnoreCase(
                wine.getWinery())) {
            newWineToDB.setWinery(
                    wine.getWinery());
        }

        if (Objects.nonNull(wine.getVintage())
                && !"".equalsIgnoreCase(
                wine.getVintage())) {
            newWineToDB.setVintage(
                    wine.getVintage());
        }

        if (Objects.nonNull(wine.getColor())
                && !"".equalsIgnoreCase(
                wine.getColor())) {
            newWineToDB.setColor(
                    wine.getColor());
        }

        if (Objects.nonNull(wine.getType())
                && !"".equalsIgnoreCase(
                wine.getType())) {
            newWineToDB.setType(
                    wine.getType());
        }

        if (Objects.nonNull(wine.getImage_pp())
                && !"".equalsIgnoreCase(
                wine.getImage_pp())) {
            newWineToDB.setImage_pp(
                    wine.getImage_pp());
        }

        newWineToDB.setPrice(wine.getPrice());

        newWineToDB.setQuantity(wine.getQuantity());

        newWineToDB.setAlcohol(wine.getAlcohol());

        wineRepository.save(newWineToDB);
    }
}
