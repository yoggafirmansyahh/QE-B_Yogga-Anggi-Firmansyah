@AssignProductRating
Feature: Assign Product Rating
  As a user
  I can assign product rating
  So that i can give the rating of each product

Background:
  Given user set API to assign rating for product

Scenario: User can assign product rating
  When user send request to assign rating
  And rating of product has assigned