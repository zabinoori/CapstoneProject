Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on sign in option
    And User enter email 'noori.test@tekschool.us' and password 'Danish@123'
    And User click on login button
    And User should be logged in into Account

  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update name 'Test' and phone '2403186822'
    And User click on update button
    Then User profile information should be updated

  Scenario: Verify Usesr can Update passowrd
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confrimPassword |
      | Danish@12345     | Danish@123  | Danish@123      |
    And User click on change passowrd button
    Then a message should be displayed 'Password Updated Successfully'

  Scenario: Verify User can add a payment method
    When User click on Account option
    * User click on Add a payment method link
    * User fill Debit or Credit card information
      | cardNameber      | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1925478965123578 | Zabi       |              12 |           2022 |          352 |
    * User click on add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User select card with ending '5214'
    And User click on Edit option of card section
    And user edit information with below data
      | cardNameber      | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1925478965123578 | Zabi       |              10 |           2023 |          182 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User select card with ending '5214'
    And User click on remove option of card section
    Then payment details should be removed

  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipcode      |
      | countryvalue | fullnamevalue | phonevalue  | stAddress     | aptvalue | cityvalue | statevalue | zipCodevalue |
    And user click add Your Address button
    Then a message should be displayed 'Address added Successfully'

  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country      | fullName      | phoneNumber | streetAddress | apt      | city      | state      | zipcode      |
      | countryvalue | fullnamevalue | phonevalue  | stAddress     | aptvalue | cityvalue | statevalue | zipCodevalue |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
