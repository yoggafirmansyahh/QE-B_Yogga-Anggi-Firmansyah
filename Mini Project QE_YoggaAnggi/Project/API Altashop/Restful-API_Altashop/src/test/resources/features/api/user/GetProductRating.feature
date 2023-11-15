Feature: Get Product Rating
  As a user
  I can get product rating
  So that i can have an information about product rating

  Scenario: User can get product rating
    Given user set API get product rating
    When user send request to get product rating
    Then user receive a rating information of product
