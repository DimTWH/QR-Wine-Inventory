package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    public Wine insertWine(Wine wine) {
        UUID uid = UUID.randomUUID();
        wine.setUid(uid);
        return wineRepository.save(wine);
    }

    public List<Wine> getAllWine() {
        return (List<Wine>) wineRepository.findAll();
    }

    public Optional<Wine> getWineById(UUID id) {
        return wineRepository.findById(id);
    }

    public void deleteWineById(UUID id) {
        wineRepository.deleteById(id);
    }

    public Wine updateWine(UUID wineId, Wine wine)
    {
        System.out.println("In Sssserviceee");
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
