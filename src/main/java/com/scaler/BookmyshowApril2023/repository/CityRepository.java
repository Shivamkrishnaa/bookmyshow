package com.scaler.BookmyshowApril2023.repository;

import com.scaler.BookmyshowApril2023.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City save(City city);
    Optional<City> findById(Long id);
    List<City> findAllByName(String name);
}
