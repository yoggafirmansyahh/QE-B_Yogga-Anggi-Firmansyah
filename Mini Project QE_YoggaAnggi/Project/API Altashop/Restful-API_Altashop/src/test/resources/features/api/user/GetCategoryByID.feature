Feature: Get Category by ID
  As a user
  I can get category by ID
  So that i can access category information based on ID

  Scenario: User can get a category based on ID
    Given user set API get category by ID
    When user send request to get category by ID
    Then user receive status code for get category by ID
    And user receive an information of category based on ID