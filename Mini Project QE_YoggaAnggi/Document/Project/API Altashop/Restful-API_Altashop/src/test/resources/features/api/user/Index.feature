Feature: Get Index
  As a user
  I can get index feature
  So that i can get Hello Feature

  Scenario: User can get hello message
    Given user set API get index
    When user send request to get index
    Then user receive an hello feature
