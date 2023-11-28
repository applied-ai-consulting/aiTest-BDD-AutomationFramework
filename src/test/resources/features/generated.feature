Feature: User Registration
  Background:
    Given I am on the login page
    And I have logged in successfully

  Scenario: Register for a course
    When I click on "Courses"
    And I click on the first course
    And I click on "Register"
    And I enter "Atharv" in the "First Name" field
    And I enter "Karbhari" in the "Last Name" field
    And I enter "atharvkarbhari123@gmail.com" in the "Email" field
    And I enter "45267-88184" in the "Postal Code" field
    And I click on "Register"
    Then I should be successfully registered for the course