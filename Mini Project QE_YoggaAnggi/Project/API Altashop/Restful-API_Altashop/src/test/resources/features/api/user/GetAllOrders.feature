Feature: Get All Orders
  As a user
  I can get all orders
  So that i can access information of all orders on the cart

  Scenario: User can get all orders
    Given user set API get all orders
    When user send request to get all orders
    Then user receive an information of all orders
