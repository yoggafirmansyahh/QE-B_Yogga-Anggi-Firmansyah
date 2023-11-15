Feature: Login
  As a user
  I want to login
  So that i can access the dashboard page

  Scenario: Login with valid credentials
    Given user set API Endpoint to login
    When user send request a valid email and password to login
    And login success and get response 200 for login valid

  Scenario: Login with use a wrong email
    Given user set API Endpoint to login
    When user send request an invalid email and valid password for login
    And login failed and will get error message with status code 400 'wrong email'

