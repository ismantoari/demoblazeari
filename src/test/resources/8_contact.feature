Feature: Contact

  @web
  Scenario: check menu contact
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    When user click menu "Contact"
    Then appear form message

  @web
  Scenario: send message via contact
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Contact"
    And appear form message
    And user input email "ari@test.com"
    And user input name "ari"
    And user input message "tanya harga hp samsung terbaru"
    When user click button Send message
    Then user see notification pop up "Thanks for the message!!"

  @web
  Scenario: Cancel send message via contact
    Given user is on home page
    And user click login menu
    And user input login username "UserFinalProject"
    And user input login password "FinalProject_2024"
    And user click login button
    And user see logout menu
    And user click menu "Contact"
    And appear form message
    When user click button Close
    Then form send message is close