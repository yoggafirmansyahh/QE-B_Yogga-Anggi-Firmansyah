Feature: Delete Product
  As a user
  I can delete the product
  So that i can delete product that i want

  Scenario: User can delete a product
    Given user set API delete product
    When user send request to delete product
    Then user receive status code for deleted product
