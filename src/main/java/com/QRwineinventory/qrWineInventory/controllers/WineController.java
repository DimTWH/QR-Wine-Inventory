package com.QRwineinventory.qrWineInventory.controllers;

import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("inventory/wine")
@RestController
public class WineController {

    private final WineService wineservice;

    @Autowired
    public WineController(WineService wineservice) {
        this.wineservice = wineservice;
    }

    @PostMapping(path = "new")
    public void addWine(@RequestBody Wine wine) {
        wineservice.insertWine(wine);
    }

    @GetMapping(path = "all")
    public List<Wine> getAllWine() {
        return wineservice.getAllWine();
    }

    @GetMapping(path = "{id}")
    public Wine getWineById(@PathVariable("id") UUID id) {
        return wineservice.getWineById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteWineById(@PathVariable("id") UUID id) {
        wineservice.deleteWineById(id);
    }

    @PutMapping(path = "update/{id}")
    public void updateWine(@PathVariable("id") UUID id, @RequestBody Wine newWine) {
        wineservice.updateWine(id, newWine);
    }
}
