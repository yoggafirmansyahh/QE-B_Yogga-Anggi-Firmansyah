Feature: Get User Information
  As a user
  I can get user information
  So that i can access the information of user based on the data

  Scenario: User can get information of user
    Given user set API get user information
    When user send request to get user information
    Then user receive status code 200 for get user information
    And user receive an information of user