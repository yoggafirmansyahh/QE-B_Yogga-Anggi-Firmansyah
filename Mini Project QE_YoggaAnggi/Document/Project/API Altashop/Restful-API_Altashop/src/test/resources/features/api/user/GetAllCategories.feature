Feature: Get All Categories
  As a user
  I can get all categories
  So that i can access information of all categories

  Scenario: User can get all categories
    Given user set API get all categories
    When user send request to get all categories
    Then user receive an information of all categories
