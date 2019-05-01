Feature: Rest API endpoints to search over available flights

  Scenario: Get all available flights
    When the client call "/api/flights" with HTTP GET method
    Then the client receives status code of 200
    And the content field has multiple items