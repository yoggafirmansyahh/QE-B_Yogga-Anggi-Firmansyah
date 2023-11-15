Feature: Get All Products
  As a user
  I can get all products
  So that i can access information of all products

  Scenario: User can get all products
    Given user set API get all products
    When user send request to get all products
    Then user receive an information of all products
