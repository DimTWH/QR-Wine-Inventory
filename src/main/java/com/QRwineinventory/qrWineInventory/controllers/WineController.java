package com.QRwineinventory.qrWineInventory.controllers;

import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@RequestMapping("inventory/wine")
@RestController
public class WineController {

    @Autowired
    private WineService wineservice;

    @PostMapping(path = "new")
    public void addWine(@Valid @NotNull @RequestBody Wine wine) {
        wineservice.insertWine(wine);
    }

    @GetMapping(path = "all")
    public List<Wine> getAllWine() {
        return wineservice.getAllWine();
    }

    @GetMapping(path = "/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("wines", wineservice.getAllWine());
        model.setViewName("index");

        return model;
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
    public void updateWine(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Wine newWine) {
        wineservice.updateWine(id, newWine);
    }
}
