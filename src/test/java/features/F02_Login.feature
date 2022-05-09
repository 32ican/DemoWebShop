




Feature: testing logging in feature

  Background:
    Given user click on log in button

  @Smoke
  Scenario: user could sign in with valid data

    When user enters email: "9@test.com" and password: "12341234"
    And clicks on log in button
    Then user could see his account

    @Regression
    Scenario: user try to log in with a valid email and invalid password

      When user enters a valid email: "9@test.com" and invalid password: "12345667"
      And clicks on log in button
      Then user could not log in to his account and error message will appear contains "The credentials provided are incorrect"

      @Regression
      Scenario: user try to log in with an invalid username
        When user enters an invalid email: "fake@test.com" and password "12341234"
        And clicks on log in button
        Then user could not log in to his account and error message will appear contains "No customer account found"

