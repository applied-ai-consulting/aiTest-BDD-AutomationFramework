
Feature: Event Feature at Wajooba Platform Users should be able to navigate to the events page, select an event, and fill out registration information for an event.

  Background:
    Given User is on the Wajooba login page
    
  @Freeevent
  Scenario: Successfully registering for an event on Wajooba
    When User navigates to the events section
    And User selects an event
    And User clicks on the register button for the selected event
    And User fills in the first name "Omkar"
    And User fills in the last name "Jodh"
   #And User fills in the email "omkar.jodh@appliedaiconsulting.com"
    And I Enter email id in the email field
    And User fills in the phone number "11112-22221"
    And User submits the registration form
    Then User should see a confirmation of successful event registration