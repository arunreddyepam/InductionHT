Feature: User Registration on Online Shopping Portal
  As a new user
  I want to register on the shopping portal
  So that I can shop and manage my account

  Background:
    Given the user is on the home page

  @registration @smoke
  Scenario: Successful registration with valid details
    When the user clicks on the Signup/Login link
    And enters name "John Doe" and email "john_doe_2025@test.com"
    And clicks on the Signup button
    Then the user should be navigated to the account information page
    When the user fills account information with password "Test@123"
    And fills the address details
    And clicks on the Create Account button
    Then the account should be created successfully

  @registration @negative
  Scenario: Registration fails with already registered email
    When the user clicks on the Signup/Login link
    And enters name "Existing User" and email "existing_user@test.com"
    And clicks on the Signup button
    Then an error message "Email Address already exist!" should be displayed

  @registration @negative
  Scenario: Registration fails when name field is empty
    When the user clicks on the Signup/Login link
    And enters name "" and email "test_empty@test.com"
    And clicks on the Signup button
    Then a validation message should be displayed for the name field

  @registration @negative
  Scenario Outline: Registration fails with invalid email formats
    When the user clicks on the Signup/Login link
    And enters name "Test User" and email "<invalidEmail>"
    And clicks on the Signup button
    Then a validation message should be displayed for the email field

    Examples:
      | invalidEmail       |
      | plainaddress       |
      | missing@dot        |
      | @missingusername   |
      | spaces in@mail.com |