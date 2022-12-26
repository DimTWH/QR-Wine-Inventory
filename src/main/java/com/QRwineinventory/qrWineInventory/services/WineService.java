package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.daos.WineDao;
import com.QRwineinventory.qrWineInventory.models.Wine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WineService {

    private final WineDao winedao;

    @Autowired
    public WineService(@Qualifier("fakedao") WineDao winedao) {
        this.winedao = winedao;
    }

    public int insertWine(Wine wine) {
        return winedao.insertWine(wine);
    }

    public List<Wine> getAllWine() {
        return winedao.selectAllWine();
    }

    public Optional<Wine> getWineById(UUID id) {
        return winedao.selectWineById(id);
    }

    public int deleteWineById(UUID id) {
        return winedao.deleteWineById(id);
    }

    public int updateWine(UUID id, Wine newWine) {
        return winedao.updateWineById(id, newWine);
    }
}
