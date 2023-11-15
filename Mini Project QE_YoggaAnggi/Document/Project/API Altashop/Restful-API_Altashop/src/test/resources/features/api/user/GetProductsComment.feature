Feature: Get Product Comment
  As a user
  I can get comment of product
  So that i can access information all commented product

  Scenario: User can get product comment
    Given user set API get all comment product
    When user send request to get comment product
    Then user receive an information of commented product
