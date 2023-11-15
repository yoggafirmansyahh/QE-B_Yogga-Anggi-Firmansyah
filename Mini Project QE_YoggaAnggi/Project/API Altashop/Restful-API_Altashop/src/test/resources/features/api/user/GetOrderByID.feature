Feature: Get Order by ID
  As a user
  I can get order by ID
  So that i can access order information based on ID

  Scenario: User can get order by ID
    Given user set API get order by ID
    When user send request to get order by ID
    Then user receive status code for get order by ID
    And user receive an information of order based on ID