Feature: Login
  As a user
  I want to Login
  So that I can access the dashboard page

  Background:
    Given User is on the login page

  Scenario: As a user I can login with valid credentials
    When User input an email
    And User input a password
    And User click login button
    Then User is on the product page