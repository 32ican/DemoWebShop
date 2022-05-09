

  Feature: verify that “Terms of service” is mandator

    @Regression @oneTime
    Scenario: verify that user could not check out a product with out agreeing to the terms of service

      Given user logged in to his account with username "9@test.com" and password "12341234"
      And user go to shopping cart
      When user try to check out the product
      Then warning box will appear contains: "Please accept the terms of service before the next step"