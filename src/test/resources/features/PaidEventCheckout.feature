Feature: Registration Confirmation

 Background:
  Given I am on the login page
  
 @Paidevent
 Scenario: Register for an Event
  When I click on the "Events" link
  And I click on the event
  And I click on the "Register" button
  And I enter my first name as "Ayush"
  And I enter my last name as "Raut"
 #And I enter my email as "ayush@appliedaiconsulting.com"
  And I Enter email id in the email field
  And I enter my phone number as "99999-99999"
  And I enter my card number as "4242 4242 4242 4242"
  And I enter the expiration date as "12 / 29"
  And I enter the CVC as "111"
  And I enter the postal code as "11111"
  And I switch to the parent frame
  And I Click on the "Buy Now" button
  Then I should see the registration confirmation message