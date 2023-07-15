Feature: I should be able to do product checkouts

  @UI
  Scenario: User should be able to do product checkouts end to end flow
    Given User able to launch application
    When User enter login details
    Then Verify login successful at ProductPage
    When I see Backpack product
    Then I add Backpack to Cart