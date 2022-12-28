Feature: Sign In Featrue

  Background: 
    Given User is on retail website
    When User click on Sign in option

  Scenario: Verify user can sign in into Retail Application
    And User enter email 'zabihullahnoori@yahoo.com' and password 'Danish@12345'
    And User click on login button
    Then User should be logged in into Account

  Scenario Outline: Verify user can login with different email and pass
    And User enter email <email> and password <password>
    And User click on login button
    Then User should be logged in into Account

    Examples: 
      | email                        | password       |
      | 'zabihullahnoori@yahoo.com'  | 'Danish@12345' |
      | 'zabihullahnoori2@yahoo.com' | 'Danish@12345' |
      | 'zabihullahnoori3@yahoo.com' | 'Danish@12345' |

  Scenario: Verify user can create an account into Retail website
    And User click on Create New Account button
    And user fill the signUp information with below data
      | name       | email                       | password     | confirmPassword |
      | Zabihullah | zabihullahnoori25@yahoo.com | Danish@12345 | Danish@12345    |
    And User click on SignUp button
    Then User should be logged into account page

  Scenario Outline: Verify user can create an account into Retail website
    And User click on Create New Account button
    And user fill the signUp information with below data
      | name   | email   | password   | confirmPassword   |
      | <name> | <email> | <password> | <confirmPassword> |
    And User click on SignUp button
    Then User should be logged into account page

    Examples: 
      | name       | email                          | passwored   | confirmPassword |
      | Zabihullah | Zabihulllahnoori1@tekschool.us | Danish@1234 | Danish@1234     |
      | Zabihullah | Zabihulllahnoori2@tekschool.us | Danish@1235 | Danish@1235     |
      | Zabihullah | Zabihulllahnoori3@tekschool.us | Danish@5432 | Danish@5432     |
      | Zabihullah | Zabihulllahnoori4@tekschool.us | Danish@4231 | Danish@4231     |
      | Zabihullah | Zabihulllahnoori5@tekschool.us | Danish@1122 | Danish@1122     |
