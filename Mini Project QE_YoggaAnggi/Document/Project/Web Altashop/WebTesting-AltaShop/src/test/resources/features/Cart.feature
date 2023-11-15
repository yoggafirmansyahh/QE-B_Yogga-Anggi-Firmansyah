Feature: Order
  As a user
  I want to order an item
  So that i can take item to the cart

  Background:
    Given User is on the login page
    When User input an email
    And User input a password
    And User click login button

  Scenario: As a user I can order the product
    Given User is on the product page
    When User click 'beli' button to add product on the order cart
    Then Product is added to order cart
