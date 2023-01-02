package com.QRwineinventory.qrWineInventory.repositories;

import com.QRwineinventory.qrWineInventory.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WineRepository extends JpaRepository<Wine, UUID>{
    @Query("SELECT w FROM Wine w WHERE CONCAT(w.uid, LOWER(w.brand_grape), LOWER(w.winery), w.vintage, w.price, LOWER(w.color), LOWER(w.type), w.alcohol, w.quantity) LIKE %?1%")
    List<Wine> search(String keyword);

    @Query("SELECT w FROM Wine w WHERE w.brand_grape = ?1")
    Wine findWineByBrand(String brand);
}
