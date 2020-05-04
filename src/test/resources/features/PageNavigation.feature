@smoke @lib-100 @navigation
Feature: Page navigation links
  #login as librarian
  #click on the users link
  #verify page Users

   #login as librarian
  #click on the books link
  #verify page Books

  Background:
    Given I login as a librarian user
    And I am on the login page

  Scenario: Go to users page
    When I click in "Users" link
    Then "Users" page  should be displayed


  Scenario: Go to books page
    When I click in "Books" link
    Then "Books" page  should be displayed


  Scenario: Go to dashboard page
    Given I am on the login page
    And I login as a librarian user
    And I click in "Books" link
    And I click in "Dashboard" link
    Then "Dashboard" page  should be displayed