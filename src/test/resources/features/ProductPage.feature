Feature: I should be able to do product checkouts

  @UI
  Scenario: User should be able to do product checkouts end to end flow
    Given User able to launch application
    When User enter login details
    Then Verify login successful at ProductPage
    When User see Backpack product
    Then User add Backpack to Cart
    Then User able to navigate to customer
    And User provides customer details
       | BAHUBALI | INDIA |1234GP|
