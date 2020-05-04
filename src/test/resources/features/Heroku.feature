Feature: Test case 1

  Background:
    Given I am on Heroku page
    When I click "Registration Form" link

#  @wip
  Scenario: Verify error message
    And I enter "wrong_dob" into date of birth input box
    Then Warning message is displayed: "The date of birth is not valid"


  Scenario Outline: Verify programming languages
    Then Verify that following options for programming "<languages>" are displayed:
    Examples:
      | languages  |
      | c++        |
      | java       |
      | JavaScript |