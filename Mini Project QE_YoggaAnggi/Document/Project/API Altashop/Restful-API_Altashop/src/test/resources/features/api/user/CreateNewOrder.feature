Feature: Create new order
  As a user
  I can create new order
  So that i can buy the product

  Scenario: User can create new order
    Given user set API to create new order
    When user send request to create new order
    And new order was created