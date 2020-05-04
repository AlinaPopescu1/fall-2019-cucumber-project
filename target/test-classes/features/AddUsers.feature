@show_records @smoke @lib-7031
Feature: Add Users window


  Background:
    Given I am on the login page
    When I access Users page as a librarian
    And I click on Add User

  Scenario: Add users window default dates
    Then start date should be today's date
    And end date should be one month from today

  Scenario: Add users close button
    And I enter new user information with random email
    When I click the Close link
    Then the users table should not contain user with that email


  Scenario: Save new user
    And I enter new user information with random email
    When I save new user information with random email
    Then the users table must contain the correct user information