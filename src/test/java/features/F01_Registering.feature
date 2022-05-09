


Feature: Registering customers

  Background:

    Given user at home page and clicks on register

    @Smoke
  Scenario Outline: Registering 3 new customers with valid email

    When user enters <firstName>, <lastName>, <email> and <password>
    Then User could register successfully
    And confirmation message should appear

    Examples:
      | firstName | lastName | email           | password |
      | Mof       | Zak         | 201@test.com  | 12341234 |
      | Mof       | Zak         | 301@test.com  | 12341234 |
      | Mof       | Zak         | 401@test.com  | 12341234 |

      @Regression
  Scenario:  an already registered user try to register with same data

        When user enters same data "Mof", "Zak", "20@test.com", "12341234"
        Then user could not register with same data
        And  error message should appear