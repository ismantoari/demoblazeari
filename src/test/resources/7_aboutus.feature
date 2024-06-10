Feature: About us

  @web
  Scenario: click menu About us
    Given user is on home page
    When user click menu "About us"
    Then appear pop up about us

  @web
  Scenario: close pop up About us
    Given user is on home page
    And user click menu "About us"
    When user click close button on pop up
    Then pop up About us is closed