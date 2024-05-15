Feature: Login

#  @web
#  Scenario: Open Login Form
#    Given user is on home page
#    When user click login menu
#    Then pop up login will opened

  @web
  Scenario: Valid username and password
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    When user click login button
    Then user see logout menu
    Then user see login greeting "Welcome UserFinalProject"

  @web
  Scenario: Unregistered user
    Given user is on home page
    And user click login menu
    And user input login username "UserNotRegister"
    And user input login password "FinalProject_2024"
    And user click login button
    Then user see notification pop up "User does not exist."

  @web
  Scenario: Valid username and blank input password
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password ""
    When user click login button
    Then user see notification pop up "Please fill out Username and Password."

  @web
  Scenario: Without input username and without password
    Given user is on home page
    And user click login menu
    And user input login username ""
    And user input login password ""
    When user click login button
    Then user see notification pop up "Please fill out Username and Password."

#  @web
#  Scenario: Blank username and valid password
#    Given user is on home page
#    And user click login menu
#    And user input login username ""
#    And user input login password "FinalProject_2024"
#    When user click login button
#    Then user see notification pop up "Please fill out Username and Password."

  @web
  Scenario: Cancel Login
    Given user is on home page
    And user click login menu
    When user click close button on pop up
    Then user will see menu "Log in"