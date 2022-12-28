package com.QRwineinventory.qrWineInventory.repositories;

import com.QRwineinventory.qrWineInventory.models.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WineRepository extends JpaRepository<Wine, UUID>{
}
