Feature: Home Page Verifications

  @UI
  Scenario: User verify HomePage Elements and login successful
    Given User able to launch application
    When User enter login details
    Then Verify login successful at ProductPage