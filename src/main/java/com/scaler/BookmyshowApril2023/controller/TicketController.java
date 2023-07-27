package com.scaler.BookmyshowApril2023.controller;

import com.scaler.BookmyshowApril2023.exception.ShowSeatNotAvailableException;
import com.scaler.BookmyshowApril2023.model.Ticket;
import com.scaler.BookmyshowApril2023.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Autowired
    public Ticket bookTicket(Long showId, List<Long> showSeatId, Long userId) throws ShowSeatNotAvailableException {
        return ticketService.bookTicket(showId, showSeatId, userId);
    }
}
