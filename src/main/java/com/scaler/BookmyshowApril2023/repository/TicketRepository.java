package com.scaler.BookmyshowApril2023.repository;

import com.scaler.BookmyshowApril2023.model.City;
import com.scaler.BookmyshowApril2023.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Long id);
    List<Ticket> findAllByName(String name);
}
