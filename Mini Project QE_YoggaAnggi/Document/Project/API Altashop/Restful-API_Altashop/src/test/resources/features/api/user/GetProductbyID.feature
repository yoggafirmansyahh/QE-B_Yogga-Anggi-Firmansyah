Feature: Get Product by ID
  As a user
  I can get product by ID
  So that i can access product information based on ID

Scenario: User can get product based on ID
  Given user set API get product by ID
  When user send request to get product by ID
  Then user receive status code 200 for get user by ID
  And user receive an information of product based on ID