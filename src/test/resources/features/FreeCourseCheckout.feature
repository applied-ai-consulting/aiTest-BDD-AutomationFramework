Feature: User Registration
  Background:
    Given I am on the login page
    
  @Freecourse
  Scenario: Register for a course
    When I click on the Courses
    And I click on the first course
    And I click on Course Register button
    And I enter "Atharv" in the "firstName" field
    And I enter "Karbhari" in the "lastName" field
   #And I enter "atharvkarbhari123@gmail.com" in the "email" field
    And I enter email id in the email field
    And I Enter "45267-88184" in the phonenumber field
    And I click on Register
    Then I should be successfully registered for the course