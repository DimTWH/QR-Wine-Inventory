package com.QRwineinventory.qrWineInventory.controllers;

import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("inventory/wine")
@RestController
public class WineController {

    @Autowired
    private WineService wineservice;

    @GetMapping("new")
    public ModelAndView getAddWinePage() {
        ModelAndView model = new ModelAndView("create");
        return model;
    }
    @PostMapping(path = "saveNew")
    public ModelAndView addWine(@Valid @NotNull Wine wine) {
        wineservice.insertWine(wine);
        ModelAndView model = new ModelAndView("redirect:new");
        return model;
    }

    @GetMapping(path = "all")
    public List<Wine> getAllWine() {
        return wineservice.getAllWine();
    }

    @GetMapping(path = "/index")
    public ModelAndView index(ModelMap map) {
        ModelAndView model = new ModelAndView();
        model.addObject("wines", wineservice.getAllWine());
        model.setViewName("index");

        if (!map.isEmpty()) model.addObject("message", map.getAttribute("message"));
        else model.addObject("message", "");

        return model;
    }

    @GetMapping
    public ModelAndView getWineById(@RequestParam("id") UUID id) {
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.setViewName("wineProfile");
        }
        else {
            System.out.println("NOT FOUND");
            model.setViewName("index");
        }
        return model;
    }

    @GetMapping(path = "delete")
    public ModelAndView deleteWineById(@RequestParam("id") UUID id) {
        System.out.println("deleting");
        wineservice.deleteWineById(id);
        String message = "Wine successfully deleted";
        ModelAndView model = new ModelAndView();
        model.addObject("message", message);
        model.setViewName("redirect:../index");
        return model;
    }

    @GetMapping("update")
    public ModelAndView getUpdateWinePage(@RequestParam("id") UUID id) {
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.setViewName("update");
        }
        else {
            model.setViewName("index");
        }
        return model;

    }

    @PostMapping("save")
    public ModelAndView updateWine(@RequestParam("idWOW") UUID id, @Valid @NonNull Wine newWine) {
        System.out.println("herrrrrreeeeee");
        wineservice.updateWine(id, newWine);

        String message = "Wine successfully updated";
        ModelAndView model = new ModelAndView();
        model.addObject("message", message);
        model.setViewName("redirect:index");
        return model;
    }


    @GetMapping("logo")
    public String getLogo() throws IOException {
        Path path = Paths.get("C:\\Users\\DimHP\\Documents\\- EhB (hp)\\BATI 2\\Java Advanced\\qrWineInventory\\src\\main\\resources\\pictures\\logo-h.png");
        byte[] data = Files.readAllBytes(path);
        byte[] encoded = Base64.getEncoder().encode(data);
        String imgDataAsBase64 = new String(encoded);
        String imgAsBase64 = "data:image/png;base64," + imgDataAsBase64;

        return imgAsBase64;
    }
}
