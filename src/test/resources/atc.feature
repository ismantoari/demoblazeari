Feature: Add To Cart

  @web
  Scenario: Pop up Product Added will appear after user Add To Cart product
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click product "Samsung galaxy s6"
    And user is on product page "Samsung galaxy s6"
    When user click button add to cart
    Then user see notification pop up "Product added."

  @web
  Scenario: Product will added to cart after user add to chart
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Cart"
    And user have no any product on cart
    And user click menu "Home "
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    When user click menu "Cart"
    Then user see product "Nokia lumia 1520" in the cart

  @web
  Scenario: Correct product price on homepage and cart
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Cart"
    And user have no any product on cart
    And user click menu "Home "
    And user check price of "Nokia lumia 1520" on homepage
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    When user click menu "Cart"
    Then user see same price of "Nokia lumia 1520" on cart


  @web
  Scenario Outline: delete product on cart
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Cart"
    And user have no any product on cart
    And user click menu "Home "
    And user click product "<Test data product name>"
    And user is on product page "<Test data product name>"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    And user click menu "Cart"
    And user see product "<Test data product name>" in the cart
    When user click delete for "<Test data product name>"
    Then product "<Test data product name>" is reduce from cart

    Examples:
      |Test data product name    |
      |Nokia lumia 1520          |

  @web
  Scenario: Total price product on cart
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Cart"
    And user have no any product on cart
    And user click menu "Home "
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    And user click menu "Home "
    And user click product "Samsung galaxy s6"
    And user is on product page "Samsung galaxy s6"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    When user click menu "Cart"
    Then user assert total amount in the cart

  @web
  Scenario: Place Order
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Cart"
    And user have no any product on cart
    And user click menu "Home "
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    And user click menu "Cart"
    When user click button Place Order
    Then user see form Place Order