package com.myboilerplate.myboilerplate.flight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    private List<Flight> flights;

    public FlightService() {
        flights = new ArrayList<>();
        Flight f1 = new Flight();
        f1.setArrivalLocation("Istanbul");
        f1.setArrivalTime(new Date());
        f1.setDepartureLocation("Stockholm");
        f1.setDepartureTime(new Date());
        f1.setId(1);

        Flight f2 = new Flight();
        f2.setArrivalLocation("Barcelona");
        f2.setArrivalTime(new Date());
        f2.setDepartureLocation("Stockholm");
        f2.setDepartureTime(new Date());
        f2.setId(2);

        flights.add(f1);
        flights.add(f2);
    }

    public List<Flight> getFlights(){
        return this.flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }
}
