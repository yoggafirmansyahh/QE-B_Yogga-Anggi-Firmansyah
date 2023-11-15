Feature: Register
  As a user
  I want to register
  So that i can login and access the dashboard page

Scenario: Register Success
  Given user set API Endpoint to register page
  When user send request with a valid email and password to register
  And register success

Scenario:  Register with registered email
  Given user set API Endpoint to register page
  When user send request with registered email and password to register
  And register failed and get error message

