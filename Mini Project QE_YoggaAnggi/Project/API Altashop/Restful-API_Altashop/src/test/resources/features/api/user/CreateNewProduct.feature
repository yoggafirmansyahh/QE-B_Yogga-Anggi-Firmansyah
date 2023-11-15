Feature: Create new products
  As a user
  I can create new products
  So that i can add new products

  Scenario: User can create new product
    Given user set API to create new product
    When user send request to create new product
    And new product was created