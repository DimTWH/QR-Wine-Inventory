package com.QRwineinventory.qrWineInventory.daos;

import com.QRwineinventory.qrWineInventory.models.Wine;

import java.util.UUID;

public interface WineDao {

    int insertWine(UUID id, Wine wine);
    default int insertWine(Wine wine){
        UUID id = UUID.randomUUID();
        return insertWine(id, wine);
    }
}
