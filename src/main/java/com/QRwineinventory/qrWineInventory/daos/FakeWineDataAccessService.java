package com.QRwineinventory.qrWineInventory.daos;

import com.QRwineinventory.qrWineInventory.models.Wine;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeWineDataAccessService implements WineDao{
    private static List<Wine> DB = new ArrayList<>();
    @Override
    public int insertWine(UUID id, Wine wine) {
        DB.add(new Wine(wine.getId(), wine.getName(), wine.getVintage(), wine.getPrice(), wine.getColor(), wine.getType(), wine.getAlcohol(), wine.getQuantity(), wine.getImage_pp()));
        return 1;
    }
}
