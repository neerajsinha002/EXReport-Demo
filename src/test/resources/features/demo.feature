Feature: Test the mercury site

  Scenario: User books the flight
    Given User login to the application
    When User selects the flight details
      | type           | One Way    |
      | Passengers     | 2          |
      | Departing From | London     |
      | On             | October,6  |
      | Arriving In    | Paris      |
      | Returning      | October,15 |
    And User selects the preferences
      | Service Class | First Class      |
      | Airline       | Unified Airlines |
    Then User clicks on continue button
    Then User selects the flight options
    And User enters the journey details