@php
  Feature: php travel test suite

    @php1
    Scenario: Booking Flights oop
      Given I goto "php" page
      And I click on "Demo"
      Then I navigate to front-end page
      Then I click on "Flights" section
      And I select "One Way" trip type
      When I select "SFO" and "LAX" destinations and "2020-07-23"
      Then I select number of "adults","child","infant"
      And I click on "search"