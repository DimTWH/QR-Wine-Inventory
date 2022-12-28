package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.daos.WineDao;
import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        Wine wineFromDB = wineRepository.findById(wineId).get();

        if (Objects.nonNull(wine.getBrandGrape())
                && !"".equalsIgnoreCase(
                wine.getBrandGrape())) {
            wineFromDB.setBrandGrape(
                    wine.getBrandGrape());
        }

        if (Objects.nonNull(
                wine.getWinery())
                && !"".equalsIgnoreCase(
                wine.getWinery())) {
            wineFromDB.setWinery(
                    wine.getWinery());
        }

        if (Objects.nonNull(wine.getVintage())
                && !"".equalsIgnoreCase(
                wine.getVintage())) {
            wineFromDB.setVintage(
                    wine.getVintage());
        }

        if (Objects.nonNull(wine.getColor())
                && !"".equalsIgnoreCase(
                wine.getColor())) {
            wineFromDB.setColor(
                    wine.getColor());
        }

        if (Objects.nonNull(wine.getType())
                && !"".equalsIgnoreCase(
                wine.getType())) {
            wineFromDB.setType(
                    wine.getType());
        }

        if (Objects.nonNull(wine.getImage_pp())
                && !"".equalsIgnoreCase(
                wine.getImage_pp())) {
            wineFromDB.setImage_pp(
                    wine.getImage_pp());
        }

        wineFromDB.setPrice(wine.getPrice());

        wineFromDB.setQuantity(wine.getQuantity());

        wineFromDB.setAlcohol(wine.getAlcohol());

        return wineRepository.save(wineFromDB);
    }
}
