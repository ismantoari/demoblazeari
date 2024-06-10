Feature: Product Detail

  @web
  Scenario: web page redirect to product page after click a product on homepage and
    Given user is on home page
    When user click product "Samsung galaxy s6"
    Then user is on product page "Samsung galaxy s6"

  @web
  Scenario: Same product price on home page and product page
    Given user is on home page
    And user check price of "Nokia lumia 1520" on homepage
    When user click product "Nokia lumia 1520"
    Then user see same price of "Nokia lumia 1520" on product page

  @web
  Scenario: Product description on product page
    Given user is on home page
    When user click product "Samsung galaxy s6"
    Then there is product description on product page

  @web
  Scenario: Product image on product page
    Given user is on home page
    When user click product "Samsung galaxy s6"
    Then there is product image "galaxy_s6.jpg" on product page

  @web
  Scenario: Button add to cart on product page
    Given user is on home page
    When user click product "Samsung galaxy s6"
    Then there is button add to cart on product page