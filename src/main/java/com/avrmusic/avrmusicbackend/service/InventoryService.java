package com.avrmusic.avrmusicbackend.service;

import com.avrmusic.avrmusicbackend.entity.Inventory;
import com.avrmusic.avrmusicbackend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    public InventoryRepository inventoryRepository;

    //get all
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    //get specific inventory item

    public Optional<Inventory> getItemDetails(@PathVariable long id) {
        return inventoryRepository.findById(id); //findById??

        //also see if we can add the error handling. (orElseThrow()???)

    }


    public Inventory createInventoryItem(@RequestBody Inventory item) {
        return inventoryRepository.save(item);
    }



    //update
    @Transactional
    public Inventory updateItem (@RequestBody Inventory item, @PathVariable long id) {
        Inventory  itemToUpdate = inventoryRepository.getById(id);
        itemToUpdate.setName(item.getName());
        itemToUpdate.setCategory(item.getCategory());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setImage(item.getImage());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setVideo(item.getVideo());
        itemToUpdate.setStock(item.getStock());

        return inventoryRepository.save(itemToUpdate);
    }

    //delete

    public void deleteInventoryItem (@PathVariable long id) {
        Inventory itemToDelete = inventoryRepository.getById(id); //findById??
        inventoryRepository.delete(itemToDelete);
    }
}
