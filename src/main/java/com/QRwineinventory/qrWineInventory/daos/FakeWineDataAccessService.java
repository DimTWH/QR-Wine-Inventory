package com.QRwineinventory.qrWineInventory.daos;

import com.QRwineinventory.qrWineInventory.models.Wine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakedao")
public class FakeWineDataAccessService implements WineDao{
    private final static List<Wine> DB = new ArrayList<>();
    @Override
    public int insertWine(UUID id, Wine wine) {
        DB.add(new Wine(id, wine.getBrandGrape(), wine.getWinery(), wine.getVintage(), wine.getPrice(), wine.getColor(), wine.getType(), wine.getAlcohol(), wine.getQuantity(), wine.getImage_pp()));
        return 1;
    }

    @Override
    public List<Wine> selectAllWine() {
        return DB;
    }

    @Override
    public Optional<Wine> selectWineById(UUID id) {
        return DB.stream()
                .filter(wine -> wine.getUid().equals(id))
                .findFirst();
    }

    @Override
    public int deleteWineById(UUID id) {
        Optional<Wine> wineMaybe = selectWineById(id);
        if (wineMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(wineMaybe.get());
        return 1;
    }

    @Override
    public int updateWineById(UUID idWineToUpdate, Wine newWine) {
        return selectWineById(idWineToUpdate)
                .map(wineFound -> {
                    int indexOfWineToUpdate = DB.indexOf(wineFound);
                    if (indexOfWineToUpdate >= 0) {
                        System.out.println("updating...");
                        DB.set(indexOfWineToUpdate,
                                new Wine(idWineToUpdate,
                                        newWine.getBrandGrape(),
                                        newWine.getWinery(),
                                        newWine.getVintage(),
                                        newWine.getPrice(),
                                        newWine.getColor(),
                                        newWine.getType(),
                                        newWine.getAlcohol(),
                                        newWine.getQuantity(),
                                        newWine.getImage_pp()
                                ));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
