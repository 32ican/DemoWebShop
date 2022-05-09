

  Feature: Adding discount code

    @Regression
    Scenario: user could add discount code "AutomationDiscount2" that gives 20% discount

      Given user logged in to his account with username "9@test.com" and password "12341234"
      When user go to shopping cart
      And give the discount code "AutomationDiscount2"
      Then user could see a confirmation message contains: " "
      And the discount is 20%
