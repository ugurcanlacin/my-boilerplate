package com.myboilerplate.myboilerplate.unit;

import com.myboilerplate.myboilerplate.flight.Flight;
import com.myboilerplate.myboilerplate.flight.FlightService;
import cucumber.api.java.bs.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightTest {

    @Autowired
    FlightService flightService;

    @Test
    public void testAllFlights(){
        List<Flight> flights = flightService.getFlights();
        assertTrue(flights.size() > 1);
    }
}
