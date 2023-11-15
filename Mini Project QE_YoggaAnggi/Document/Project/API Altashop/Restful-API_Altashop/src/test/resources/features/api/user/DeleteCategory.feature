Feature: Delete Category
  As a user
  I can delete the category
  So that i can delete category that i want

  Scenario: User can delete a category
    Given user set API delete category
    When user send request to delete category
    Then user receive status code for deleted category
