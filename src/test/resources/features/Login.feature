Feature: Login functionality


  @positive_testcase
  Scenario: Login with valid credential
    Given User opens the Applications
    When User enters valid email 'amotooricap1@gmail.com' into the email field
    And User enters valid password 12345 into the password field
    And User clicks on Login button on page
    Then User should get successfully loggedin


  @negative_testcase
  Scenario Outline: Login with invalid credential
    Given User navigate to login page
    When User gives <condition> in field
    And User clicks on Login button on page
    Then User should get a warning message about credentials mismatch
    Examples:
      |    condition	 |
      | invalidEmail     |
#      | invalidPassword  |
#      | emptyEmail       |
#      | emptyPassword    |
#      | emptyCredential  |





