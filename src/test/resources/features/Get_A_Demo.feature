@Demo_Page @MVP

  Feature: TextUs - Request a Demo Page

    Scenario: Validate Unsuccessful Request a Demo - Email Formatted Incorrectly
      Given I access the request a demo page
      And I enter a first name Matt
      And I enter a last name Schmitt
      And I enter a email MattSchmitt.com
      And I enter a phone number 9076124455
      And I enter a company name Fairfield
      And I enter how many people need texting
      And I enter ats crm in use
      And I enter how textUs can help org
      And I enter a comment "How is everybody doing at TextUs today!?"
      Then I should be presented with an error

