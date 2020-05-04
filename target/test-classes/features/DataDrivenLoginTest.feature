Feature: User account tests


  Scenario: Verify user information
    Given I am on the login page
    When I login using "librarian12@library" and "AOYKYTMJ"
    Then account holder name should be "Test Librarian 12"

    #DDT
    #Test Student 26 student26@library   JTvaF3br

   #TestCase
  Scenario Outline: Verify user information <email>
    Given I am on the login page
    When I login using "<email>" and "<password>"
    Then account holder name should be "<name>"

    #TestData
    @students
    Examples: Only passing
      | name            | email             | password |
      | Test Student 26 | student26@library | JTvaF3br |
      | Test Student 27 | student27@library | kkMksO2i |
      | Test Student 28 | student28@library | 19Ceq2sT |
      | Test Student 29 | student29@library | WyIUNpDI |
      | Test Student 30 | student30@library | IaT9YI0I |

    @librarians
    Examples: Only passing
      | name              | email               | password |
      | Test Librarian 13 | librarian13@library | 9rf6axdD |
      | Test Librarian 14 | librarian14@library | 87x8afWY |


  Scenario Template: Verify User Information 2 <name>
    Given I am on the login page
    When I login using following credentials:
      | email    | <email>    |
      | password | <password> |
    Then account holder name should be "<name>"

    Scenarios:
      | name              | email               | password |
      | Test Librarian 13 | librarian13@library | 9rf6axdD |
      | Test Librarian 14 | librarian14@library | 87x8afWY |


  Scenario Outline: Verify dashboard page
    * I am on the login page
    * I login as a <user> user
    * "Dashboard" page  should be displayed


    Examples:
      | user      |
      | librarian |
      | student   |