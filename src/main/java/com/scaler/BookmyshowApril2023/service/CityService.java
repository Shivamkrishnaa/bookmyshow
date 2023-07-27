package com.scaler.BookmyshowApril2023.service;

import com.scaler.BookmyshowApril2023.model.City;
import com.scaler.BookmyshowApril2023.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    public City addCity(String name){
        City newCity = new City();
        newCity.setName(name);
        return cityRepository.save(newCity);
    }
}
