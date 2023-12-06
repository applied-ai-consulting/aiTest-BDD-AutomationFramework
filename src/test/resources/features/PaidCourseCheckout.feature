Feature: Purchase Course As a user I want to purchase a course So that I can access the course content

 Background:
  Given I am on the login page
  
 @Paidcourse
 Scenario: Purchase a Course
  When I click on the Courses
  And I click on the course image
  And I click on the "Register" button
  And I enter "Atharv" in the "firstName" field
  And I enter "Karbhari" in the "lastName" field
 #And I enter "atharvkarbhari123@gmail.com" in the "email" field
  And I enter email id in the email field
  And I Enter "45267-88184" in the phonenumber field
  And I enter my card number as "4242 4242 4242 4242"
  And I enter the expiration date as "12 / 29"
  And I enter the CVC as "111"
  And I enter the postal code as "11111"
  And I switch to the parent frame
  And I Click on the "Buy Now" button
  Then I should see the registration confirmation message