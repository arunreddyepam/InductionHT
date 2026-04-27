Feature: User Sign-In and Sign-Out functionality
  As a registered user
  I want to sign in and sign out of the portal
  So that I can access my account securely

  Background:
    Given the user is on the home page
    When the user clicks on the Signup/Login link

  @signin @smoke
  Scenario: Successful sign-in with valid credentials
    When the user enters login email "valid_user@test.com" and password "Test@123"
    And clicks on the Login button
    Then the user should be logged in successfully
    And a "Logged in as" message should be displayed

  @signin @negative
  Scenario: Sign-in fails with invalid credentials
    When the user enters login email "wrong_user@test.com" and password "WrongPass!"
    And clicks on the Login button
    Then an error message "Your email or password is incorrect!" should be displayed

  @signin @negative
  Scenario: Sign-in fails with empty credentials
    When the user enters login email "" and password ""
    And clicks on the Login button
    Then the user should remain on the login page

  @signout @smoke
  Scenario: Successful sign-out after login
    When the user enters login email "valid_user@test.com" and password "Test@123"
    And clicks on the Login button
    Then the user should be logged in successfully
    When the user clicks on the Logout link
    Then the user should be redirected to the login page

  @signin @negative
  Scenario Outline: Sign-in fails with invalid email formats
    When the user enters login email "<email>" and password "<password>"
    And clicks on the Login button
    Then an error message "Your email or password is incorrect!" should be displayed

    Examples:
      | email             | password    |
      | unknown@test.com  | SomePass1!  |
      | random@mail.com   | Wrong@123   |