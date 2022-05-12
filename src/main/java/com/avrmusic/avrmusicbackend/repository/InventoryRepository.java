package com.avrmusic.avrmusicbackend.repository;

import com.avrmusic.avrmusicbackend.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
