package com.scaler.BookmyshowApril2023.repository;

import com.scaler.BookmyshowApril2023.model.City;
import com.scaler.BookmyshowApril2023.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Show save(Show show);
    Optional<Show> findById(Long id);

}
