@AddNewProduct
Feature: AddNewProduct
	As a user 
	I want to add new product
	So that the new product is added on the dashboard page
	
  @Add-new-item-success
  Scenario: User can add new item
    Given user on home page
    When user click plus button
    And user fill the product name
    And user fill the product quantity
    And user choose the product categories
    And user click the add button
    Then item will be on the home page

    
   @Add-new-item-blank-name
   Scenario: User add new item with not fill the item name
   Given user on home page
   When user click plus button
   And user dont fill the product name
   And user fill the product quantity
   And user choose the product categories
   And user click the add button
   Then user see Must be between 1 and 50 characters message