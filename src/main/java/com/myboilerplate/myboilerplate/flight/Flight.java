package com.myboilerplate.myboilerplate.flight;

import lombok.Data;

import java.util.Date;

@Data
public class Flight {
    private Integer id;
    private String departureLocation;
    private String arrivalLocation;
    private Date departureTime;
    private Date arrivalTime;
}
