Feature: I should be able to do product checkouts

  @UI
  Scenario:
    Given I land on HomePage
    When I enter login details
    Then I land to ProductPage
    When I see Backpack product
    Then I add Backpack to Cart