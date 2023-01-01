package com.QRwineinventory.qrWineInventory.daos;

import com.QRwineinventory.qrWineInventory.models.Wine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql")
public class WineDataAccessService implements WineDao{
    @Override
    public int insertWine(UUID id, Wine wine) {
        return 0;
    }

    @Override
    public List<Wine> selectAllWine() {
        return List.of(new Wine(UUID.randomUUID(), "Lupi", "Merlot Cabernet Sauvignon", "Gitana", 18, "red", "dry", 14, 12, "url/images/pp"));
    }

    @Override
    public Optional<Wine> selectWineById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteWineById(UUID id) {
        return 0;
    }

    @Override
    public int updateWineById(UUID id, Wine wine) {
        return 0;
    }
}
