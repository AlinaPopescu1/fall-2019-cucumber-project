@show_records @smoke @lib-2353
Feature: Show records dropdown functionality

  Background:
    Given I am on the login page
    When I login as a librarian user


  Scenario: verify default values in Users page
    When I click in "Users" link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |


  Scenario: Change number of rows on Users page
    And I click in "Users" link
    When I select Show 50 records
    Then show records default value should be 50
    And the users table should display 50 records


    Scenario Outline: Show records <count> options
      And I click in "Users" link
      When I select Show <count> records
      Then show records default value should be <count>
      And the users table should display <count> records
      Examples:
      |count|
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
