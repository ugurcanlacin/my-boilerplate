package com.myboilerplate.myboilerplate;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//The main goal, the one you’re most interested in,is that
//this class is configured to @RunWith(SpringRuner.class).
//That annotation, together with @SpringBootTest, will instruct our test
//to load the Web Application Context. Since we want to run this test on
//a real server and not to use MockMVC, we need to use either WebEnvironment.RANDOM_PORT
//or WebEnvironment.DEFINED_PORT. Note that this is an abstract class,
//so we need something else that extends it to make the whole set up work.
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SpringBootBaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBaseIntegrationTest.class);

    private final String SERVER_URL = "http://localhost";

    private RestTemplate restTemplate;

//    The random port gets injected into the class as configured with the @LocalServerPort annotation.
    @LocalServerPort
    protected int port;

    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    protected RestTemplate getRestTemplate(){
        return this.restTemplate;
    }

    protected String baseUrl() {
        return SERVER_URL + ":" + port;
    }

    int put(final String something) {
        return restTemplate.postForEntity(baseUrl(), something, Void.class).getStatusCodeValue();
    }

//    Bag getContents() {
//        return restTemplate.getForEntity(thingsEndpoint(), Bag.class).getBody();
//    }

    void clean() {
        restTemplate.delete(baseUrl());
    }
}
