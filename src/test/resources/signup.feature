Feature: Sign Up

  @web
  Scenario: Sign up with complete username and password
    Given user is on sign up form
    And user input new username
    And user input password "FinalProject_2024"
    When user click sign up button
    Then user see notification pop up "Sign up successful."

  @web
  Scenario: Sign up without input username
    Given user is on sign up form
    And user input username ""
    And user input password "FinalProject_2024"
    When user click sign up button
    Then user see notification pop up "Please fill out Username and Password."

  @web
  Scenario: Sign up without input password
    Given user is on sign up form
    And user input username "megauser2024"
    And user input password ""
    When user click sign up button
    Then user see notification pop up "Please fill out Username and Password."

  @web
  Scenario: Sign up without input username and password
    Given user is on sign up form
    And user input username ""
    And user input password ""
    When user click sign up button
    Then user see notification pop up "Please fill out Username and Password."


  @web
  Scenario: Sign up with username that already exist
    Given user is on sign up form
    And user input username "megauser2024"
    And user input password "FinalProject_2024"
    When user click sign up button
    Then user see notification pop up "This user already exist."

  @web
  Scenario: Cancel sign up
    Given user is on sign up form
    And user input username "UserToCancelSignup"
    And user input password "FinalProject_2024"
    When user click close button on sign up form
    Then username "UserToCancelSignup" with password "FinalProject_2024" will not registered or "User does not exist."