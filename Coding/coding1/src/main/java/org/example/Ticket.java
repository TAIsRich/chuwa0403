package org.example;

import java.util.Date;
public class Ticket {
    private String id;
    private float amount;
    private Vehicle vehicle;
    private Date enterTime;
    private Date exitTime;

    private int status; //paid or not
    private int paymentMethod; //credit, debit, cash

}
