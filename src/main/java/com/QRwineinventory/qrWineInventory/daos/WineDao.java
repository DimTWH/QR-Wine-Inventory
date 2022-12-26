package com.QRwineinventory.qrWineInventory.daos;

import com.QRwineinventory.qrWineInventory.models.Wine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WineDao {

    int insertWine(UUID id, Wine wine);
    default int insertWine(Wine wine){
        UUID id = UUID.randomUUID();
        System.out.println("id = " + id);
        return insertWine(id, wine);
    }

    List<Wine> selectAllWine();

    Optional<Wine> selectWineById(UUID id);

    int deleteWineById(UUID id);

    int updateWineById(UUID id, Wine wine);
}
