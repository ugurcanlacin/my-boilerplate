package com.myboilerplate.myboilerplate.flight;

import lombok.Data;

@Data
public class FlightRequestParams {
    private String sort;
    private String fields;
    private String page;
    private String perPage;
}
