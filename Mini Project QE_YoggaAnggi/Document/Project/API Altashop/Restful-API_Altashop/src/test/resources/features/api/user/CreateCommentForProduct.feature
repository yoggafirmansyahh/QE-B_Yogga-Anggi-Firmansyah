Feature: Create comment for product
  As a user
  I can create a comment
  So that i comment for some product on website

  Scenario: User can create new comment on product
    Given user set API to comment for product
    When user send request to comment product
    And product has commented