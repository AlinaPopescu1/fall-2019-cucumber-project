
Feature: Books table

  @wip
  Scenario: Verify search results
    Given I am on the login page
    And I login to application as a librarian
    When I navigate to "Books" page
    And I search for "The Goldfinch"
    Then books table should contain results matching The Goldfinch


  Scenario: Verify book information
    Given I am on the login page
    And I login to application as a librarian
    And I navigate to "Books" page
    When I edit the book The kite runner
    Then I verify book information
      | name           | author          | year |
      | Th kite runner | Khaled Hosseini | 2003 |








