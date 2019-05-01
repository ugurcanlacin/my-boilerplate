package com.myboilerplate.myboilerplate.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/flights")
public class FlightController {

    public static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightService flightService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllFlights(FlightRequestParams flightRequestParams){
        String fields = flightRequestParams.getFields();
        Integer page = flightRequestParams.getPage();
        Integer perPage = flightRequestParams.getPerPage();
        String sort = flightRequestParams.getSort();

        if (page == 1){
            throw new NumberFormatException();
        }
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postFlight(@RequestBody Flight flight){
        flightService.addFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity putFlight(@RequestBody Flight flight){
//        flightService.addFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteFlight(@RequestBody Flight flight){
//        flightService.addFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

}
