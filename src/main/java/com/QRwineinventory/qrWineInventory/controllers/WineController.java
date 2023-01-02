package com.QRwineinventory.qrWineInventory.controllers;

import com.QRwineinventory.qrWineInventory.exceptions.InvalidSellingQuantity;
import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.services.WineService;

import com.google.zxing.WriterException;

import org.springframework.lang.NonNull;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@RequestMapping("inventory/wine")
@RestController
public class WineController {

    private final WineService wineservice;

    public WineController(WineService wineservice) {
        this.wineservice = wineservice;
    }

    @GetMapping("new")
    public ModelAndView getAddWinePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("search", "");
        model.setViewName("create");
        return model;
    }

    @PostMapping("saveNew")
    public ModelAndView addWine(@Valid @NotNull Wine wine)
            throws WriterException, IOException {
        wineservice.insertWine(wine, null);
        return new ModelAndView("redirect:new");
    }

    @GetMapping("sell")
    public ModelAndView getWineSellingPage(@RequestParam("id") UUID id) throws IOException {
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.addObject("search", "");
            model.setViewName("sellWine");
        }
        else {
            model.setViewName("redirect:index");
        }
        return model;
    }

    @PostMapping("sellWine")
    public ModelAndView sellWine(@RequestParam("id")UUID id, @Valid @NotNull Wine currentlySoldWine) throws InvalidSellingQuantity {
        wineservice.sellWine(id, currentlySoldWine);
        ModelAndView model = new ModelAndView();
        model.addObject("search", "");
        model.setViewName("redirect:index");
        return model;
    }

    @GetMapping("restock")
    public ModelAndView getWineRestockingPage(@RequestParam("id") UUID id) throws IOException {
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.addObject("search", "");
            model.setViewName("restockWine");
        }
        else {
            model.setViewName("redirect:index");
        }
        return model;
    }

    @PostMapping("restockWine")
    public ModelAndView restockWine(@RequestParam("id")UUID id, @Valid @NotNull Wine currentlyRestockedWine) throws InvalidSellingQuantity {
        wineservice.restockWine(id, currentlyRestockedWine);
        ModelAndView model = new ModelAndView();
        model.addObject("search", "");
        model.setViewName("redirect:index");
        return model;
    }

    @GetMapping(path = "index")
    public ModelAndView index(@RequestParam(value = "search", required = false) String searchQuery, ModelMap map) throws IOException {
        List<Wine> wineList = new ArrayList<>();
        if (searchQuery != null && !searchQuery.equals("")) {
            String[] searchTermsArray = searchQuery.trim().split(" ");
            for (String sT : searchTermsArray) {
                System.out.println(sT.toLowerCase());

                List<Wine> resForWord = wineservice.getAllWine(sT.toLowerCase());

                if (wineList.size() == 0) wineList.addAll(resForWord);
                else {
                    for (Wine wRes : resForWord) {
                        for (int j = 0; j < wineList.size(); j++) {
                            Wine wList = wineList.get(j);
                            if (!wRes.equals(wList)) wineList.add(wRes);
                        }
                    }
                }
            }
        }
        else {
            wineList = wineservice.getAllWine("");
        }

        ModelAndView model = new ModelAndView();
        model.addObject("wines", wineList);
        if (searchQuery == null) model.addObject("search", "");
        else model.addObject("search", searchQuery);

        model.setViewName("index");

        if (!map.isEmpty()) model.addObject("message", map.getAttribute("message"));
        else model.addObject("message", "");

        return model;
    }

    @GetMapping
    public ModelAndView getWineById(@RequestParam("id") UUID id) throws IOException{
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.addObject("search", "");
            model.setViewName("wineProfile");
        }
        else {
            System.out.println("NOT FOUND");
            model.setViewName("redirect:index");
        }
        return model;
    }

    @GetMapping(path = "delete")
    public ModelAndView deleteWineById(@RequestParam("id") UUID id) {

        System.out.println("file deleted: "+ wineservice.deleteWineById(id));
        ModelAndView model = new ModelAndView();
        model.setViewName("redirect:index");

        return model;
    }

    @GetMapping("update")
    public ModelAndView getUpdateWinePage(@RequestParam("id") UUID id) throws IOException {
        Optional<Wine> wineFound = wineservice.getWineById(id);
        ModelAndView model = new ModelAndView();
        if (wineFound.isPresent()) {
            Wine wF = wineFound.get();
            model.addObject("wine", wF);
            model.addObject("search", "");
            model.setViewName("update");
        }
        else {
            model.setViewName("redirect:index");
        }
        return model;
    }

    @PostMapping("save")
    public ModelAndView updateWine(@RequestParam("id") UUID id, @Valid @NonNull Wine newWine) {
        wineservice.updateWine(id, newWine);

        String message = "Wine successfully updated";
        ModelAndView model = new ModelAndView();
        model.addObject("message", message);
        model.setViewName("redirect:index");

        return model;
    }


//    @GetMapping("logo")
//    public String getLogo() throws IOException {
//        //          Logo image
//        Path pathLogo = Paths.get("src/main/resources/pictures/logo-h.png");
//        byte[] dataLogo = Files.readAllBytes(pathLogo);
//        byte[] encodedLogo = Base64.getEncoder().encode(dataLogo);
//        String imgDataAsBase64Logo = new String(encodedLogo);
//        String imgAsBase64Logo = "data:image/png;base64," + imgDataAsBase64Logo;
//
//        return imgAsBase64Logo;
//    }
}
