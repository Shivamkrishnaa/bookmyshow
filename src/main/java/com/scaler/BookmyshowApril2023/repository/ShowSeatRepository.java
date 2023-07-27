package com.scaler.BookmyshowApril2023.repository;

import com.scaler.BookmyshowApril2023.model.ShowSeat;
import com.scaler.BookmyshowApril2023.model.Ticket;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<Ticket, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findByIds(List<Long> showSeatIds);

    ShowSeat save(ShowSeat seat);
}
