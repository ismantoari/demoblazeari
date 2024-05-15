Feature: Place Order

  @web
  Scenario: User full fill place order form
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    And user click menu "Cart"
    And user click button Place Order
    And user see form Place Order
    And User input name "Ari"
    And user input country "Indonesia"
    And user input city "Jakarta"
    And user input credit card "4123 1234 3321 1234"
    And user input month "April"
    And user input year "2024"
    When user click button Purchase on place order form
    Then user see thanks page "Thank you for your purchase!"

  @web
  Scenario Outline: Correct name and card number after click button purchase
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
    And user assert total amount in the cart
    And user click button Place Order
    And user see form Place Order
    And User input name "<Name>"
    And user input country "<Country>"
    And user input city "<City>"
    And user input credit card "<Card number>"
    And user input month "<Month>"
    And user input year "<Year>"
    When user click button Purchase on place order form
    Then user assert data name "<Name>" and credit card "<Card number>" on thank you page

    Examples:
      |Name   |Country   |City     |Card number         |Month   |Year   |
      |Ari    |Indonesia |Jakarta  |4123 1234 3321 1234 |April   |2024   |

  @web
  Scenario: User cancel place order
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
    And user assert total amount in the cart
    And user click button Place Order
    And user see form Place Order
    When user click button Close on place order form
    Then form place order is closed

  @web
  Scenario: User confirm Ok after place order
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click product "Nokia lumia 1520"
    And user is on product page "Nokia lumia 1520"
    And user click button add to cart
    And user see notification pop up "Product added."
    And user click ok button pop up
    And user click menu "Cart"
    And user click button Place Order
    And user see form Place Order
    And User input name "Ari"
    And user input country "Indonesia"
    And user input city "Jakarta"
    And user input credit card "4123 1234 3321 1234"
    And user input month "April"
    And user input year "2024"
    And user click button Purchase on place order form
    And user see thanks page "Thank you for your purchase!"
    When user click button OK
    Then pop up thanks page is close