@CreateACategory
Feature: Create a category
  As a user
  I can create a category
  So that i can see the product more easily

  Scenario: User can create new category
    Given user set API to create a category
    When user send request to create a category
    Then user receive status code for create a category
    And category was created