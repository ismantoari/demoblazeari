Feature: Home feature

  @web
  Scenario: Checking logo
    Given user is on home page
    When user look at the top left side of the homepage
    Then user will see logo "bm.png" and store name "PRODUCT STORE"

  @web
  Scenario: Selected Phone categories
    Given user is on home page
    When user click categories "Phones"
    Then home page only display "Phones"

  @web
  Scenario: Selected Laptops categories
    Given user is on home page
    When user click categories "Laptops"
    Then home page only display "Laptops"

  @web
  Scenario: Selected Monitors categories
    Given user is on home page
    When user click categories "Monitors"
    Then home page only display "Monitors"