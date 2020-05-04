Feature: Users table


  Scenario: Unique user ids
    Given I am on the login page
    And I login as a librarian user
    When I click in "Users" link
    Then each user ID should be unique


