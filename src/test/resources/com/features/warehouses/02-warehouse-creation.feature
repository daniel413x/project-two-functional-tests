@warehouse-creation
Feature: Warehouse creation

  Background:
    Given I am on the warehouses page
    And I have opened the create warehouse form modal

  Scenario: A new warehouse is created
    When I enter valid input for a new warehouse
    And I press the warehouse form submit button
    Then the created warehouse should appear in the list of warehouses
