package com.avrmusic.avrmusicbackend.controller;

import com.avrmusic.avrmusicbackend.entity.Inventory;
import com.avrmusic.avrmusicbackend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    public InventoryRepository inventoryRepository;

    //get all
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    //get specific inventory item
     @GetMapping("/{id}")
    public Optional<Inventory> getItemDetails(@PathVariable long id) {
        return inventoryRepository.findById(id); //findById??
         //TODO: NEED TO sort out what is an Optional and when do i need to use it. Like on the like above.

         //also see if we can add the error handling. (orElseThrow()???)

     }

     @PostMapping
     public Inventory createInventoryItem(@RequestBody Inventory item) {
        return inventoryRepository.save(item);
     }



    //update
    @PutMapping("/{id}")
    public Inventory updateItem (@RequestBody Inventory item, @PathVariable long id) {
         Inventory  itemToUpdate = inventoryRepository.getById(id);
        itemToUpdate.setName(item.getName());
        itemToUpdate.setCategory(item.getCategory());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setImage(item.getImage());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setVideo(item.getVideo());
        return inventoryRepository.save(itemToUpdate);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteInventoryItem (@PathVariable long id) {
        Inventory itemToDelete = inventoryRepository.getById(id); //findById??
        inventoryRepository.delete(itemToDelete);
    }

}
