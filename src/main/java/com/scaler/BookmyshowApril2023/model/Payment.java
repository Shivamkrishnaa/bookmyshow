package com.scaler.BookmyshowApril2023.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{

    private double amount;
    private Date timeStamp;
    private String txnId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne
    private Ticket ticket;
}

/*
    Payment : PaymentStatus -> M : 1
    Payment : Ticket -> 1 : 1
 */