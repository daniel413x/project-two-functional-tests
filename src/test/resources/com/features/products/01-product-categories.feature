@product-categories
Feature: Products

  Background:
    Given I am on the product categories page

  Scenario: Product categories are shown
    When the product categories load
    Then I should see product categories
