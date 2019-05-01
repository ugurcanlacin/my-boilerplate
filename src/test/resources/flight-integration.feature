Feature: Rest API endpoints to search over available flights

  Scenario: Get all available flights
    When the client call "/api/flights" with HTTP GET method
    Then the client receives status code of 200
    And the content field has multiple items

  Scenario: Page 1 is not accepted
    When the client call "/api/flights" with HTTP GET method
    And the client set "page" parameter as 1
    Then the API returns error