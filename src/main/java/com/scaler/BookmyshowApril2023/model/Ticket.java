package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    private double totalAmount;
    private Date timeOfBooking;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User bookedBy;
    @OneToOne
    private Payment payment;
}

/*
    Ticket : Show -> M : 1
    Ticket : ShowSeat -> 1 : M
    Ticket : Payment -> 1 : 1
 */