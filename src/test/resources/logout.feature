Feature: Logout

  @web
  Scenario: user click menu logout
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    When user click menu "Log out"
    Then user will see menu "Log in"