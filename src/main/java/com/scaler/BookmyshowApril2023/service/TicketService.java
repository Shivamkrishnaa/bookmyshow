package com.scaler.BookmyshowApril2023.service;

import com.scaler.BookmyshowApril2023.exception.ShowSeatNotAvailableException;
import com.scaler.BookmyshowApril2023.model.City;
import com.scaler.BookmyshowApril2023.model.ShowSeat;
import com.scaler.BookmyshowApril2023.model.ShowSeatStatus;
import com.scaler.BookmyshowApril2023.model.Ticket;
import com.scaler.BookmyshowApril2023.repository.CityRepository;
import com.scaler.BookmyshowApril2023.repository.ShowRepository;
import com.scaler.BookmyshowApril2023.repository.ShowSeatRepository;
import com.scaler.BookmyshowApril2023.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatId, Long userId) throws ShowSeatNotAvailableException {
        List<ShowSeat> showSeats = showSeatRepository.findByIds(showSeatId);

        for (ShowSeat showSeat: showSeats) {
            if(!showSeat.getSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("Show seat is not available");
            }
        }
        for (ShowSeat showSeat: showSeats) {
            showSeat.setSeatStatus(ShowSeatStatus.LOCKED);
            showSeatRepository.save(showSeat);
        }
        // Fetch all given show seatId
        // check if all of them are available
        // if all are available then make them locked


        // commit the changes
        // mark the booked ticked is done
        Ticket newTicket = new Ticket();
        newTicket.setShowSeats(showSeats);
        newTicket.setShow(showRepository.findById(showId).get());
        Ticket tickets = ticketRepository.save(newTicket);
        for (ShowSeat showSeat: showSeats) {
            showSeat.setSeatStatus(ShowSeatStatus.BOOKED);
            showSeatRepository.save(showSeat);
        }
        return tickets;

    }
}
