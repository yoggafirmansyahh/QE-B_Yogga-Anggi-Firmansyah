Feature: Register
  As a user
  I want to Register
  So that I can access to the login page

  Background:
    Given User is on the register page

  Scenario: As a user I can register with valid credentials
    When User input an username for register
    And User input an email for register
    And User input a password for register
    And User click register button
    Then Register success and user is on the login page