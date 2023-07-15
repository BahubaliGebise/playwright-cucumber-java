Feature: Home Page Verifications

  @UI
  Scenario: I verify HomePage Elements
    Given I land on HomePage
    When I enter login details
    Then I land to ProductPage