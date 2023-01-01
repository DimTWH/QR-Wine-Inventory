package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.repositories.WineRepository;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

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
    public Wine insertWine(Wine wine) throws WriterException, IOException, NotFoundException {
        UUID uid = UUID.randomUUID();
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
        return wineRepository.save(wine);
    }

    public List<Wine> getAllWine() {
        return (List<Wine>) wineRepository.findAll();
    }

    public Optional<Wine> getWineById(UUID id) {
        return wineRepository.findById(id);
    }

    public boolean deleteWineById(UUID id) {
        wineRepository.deleteById(id);
        Path root = Paths.get("src/main/resources/pictures");
        Optional<Wine> wineFound = getWineById(id);
        Wine wine;
        String filename = "";
        if (wineFound.isPresent())
        {
            wine = wineFound.get();
            filename = wine.getImage_pp();
        }
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            System.out.println("Filename might be empty because no wine has been found with this uID");
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Wine updateWine(UUID wineId, Wine wine)
    {
        Wine newWineToDB = new Wine();
        Optional<Wine> wineFromDB = wineRepository.findById(wineId);
        if (wineFromDB.isPresent()) {
               newWineToDB = wineFromDB.get();
        }

        if (Objects.nonNull(wine.getBrandGrape())
                && !"".equalsIgnoreCase(
                wine.getBrandGrape())) {
            newWineToDB.setBrandGrape(
                    wine.getBrandGrape());
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

        return wineRepository.save(newWineToDB);
    }
}
