Feature: Sign In Feature

  Background: 
    Given User is on retail website

  
  Scenario: Verify Retail page logo
    Then User verify retail page logo is present

  
  Scenario: Verify User can Search in Electronics Department
    When User change the category to 'Electronics'
    And User search for an item 'PlayStation'
    And User click on Search icon
    Then Item should be present

 
  Scenario: Verify User can click on All section
    When User click on All section
    Then User verifies 'Shop By department' is present


  Scenario: Verify Cart icon is present
    Then User verifies cart icon is present

  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'noori.z@tek.us' and password 'Danish@123'
    And User click on login button
    Then User should be logged in into Account

  
  Scenario: Verify user can create an account into Retail Website
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name     | email       | password | confirmPassword |
      | panthers | Sky@tek.com | Tek@1234 | Tek@1234        |
    And User click on SignUp button
    Then User should be logged into account page
