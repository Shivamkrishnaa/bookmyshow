package com.scaler.BookmyshowApril2023.controller;

import com.scaler.BookmyshowApril2023.model.City;
import com.scaler.BookmyshowApril2023.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    public City addCity(String name) {
        return cityService.addCity(name);
    }
}
