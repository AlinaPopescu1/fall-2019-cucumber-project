
Feature: Search functionality on users page

Background:
  Given I am on the login page
  And I login as a librarian user
  And I click in "Users" link

  Scenario: Search accuracy
    When I search for "test"
    Then table should contain rows with "test"


    Scenario: Table columns names
      Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
