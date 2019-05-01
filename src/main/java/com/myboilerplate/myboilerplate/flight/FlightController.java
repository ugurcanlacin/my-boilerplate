package com.myboilerplate.myboilerplate.flight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        String page = flightRequestParams.getPage();
        String perPage = flightRequestParams.getPerPage();
        String sort = flightRequestParams.getSort();
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }

}