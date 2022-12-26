package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.daos.WineDao;
import com.QRwineinventory.qrWineInventory.models.Wine;

public class WineService {

    private final WineDao winedao;

    public WineService(WineDao winedao) {
        this.winedao = winedao;
    }

    public int insertWine(Wine wine) {
        return winedao.insertWine(wine);
    }
}
