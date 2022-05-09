

  Feature: E2E Order checkout

    @Smoke
    Scenario:End to end scenario: User could order a simple computer and check it out

      Given user logged in to his account with username "6@test.com" and password "12341234"
      When user navigate to computers and select desktops
      And user add the simple computer with slow processor to the shopping cart
      And user navigate to shopping cart and check it out
      And add the address and continue
      |Country| City  | Street  | PostalCode| Phone |
      |Egypt  | Cairo | Test St.| 12345     |+12340000 |
      And continue to payment method and enter the payment information:
      | Card Type   |       Visa       |
      | Holder Name | Barbara Gordon   |
      | Card Number | 4485564059489345 |
      | Exp. Month  |      04          |
      | Exp. Year   |     2022         |
      | Card Code   |     123          |

      Then user could see confirmation message: "Your order has been successfully processed!"

