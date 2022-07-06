package com.avrmusic.avrmusicbackend.controller;

import com.avrmusic.avrmusicbackend.entity.Inventory;
import com.avrmusic.avrmusicbackend.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    //get all
    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    //get specific inventory item
     @GetMapping("/{id}")
    public Optional<Inventory> getItemDetails(@PathVariable long id) {
        return inventoryService.getItemDetails(id); //findById??
         //TODO: NEED TO sort out what is an Optional and when do i need to use it. Like on the like above.

         //also see if we can add the error handling. (orElseThrow()???)

     }

     @PostMapping
     public Inventory createInventoryItem(@RequestBody Inventory item) {
        return inventoryService.createInventoryItem(item);
     }



    //update
    @PutMapping("/{id}")
    public Inventory updateItem (@RequestBody Inventory item, @PathVariable long id) {

        return inventoryService.updateItem(item, id);
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteInventoryItem (@PathVariable long id) {

        inventoryService.deleteInventoryItem(id);
    }

}
