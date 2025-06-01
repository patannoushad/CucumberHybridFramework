@all
Feature: Login functionality


  @positive_testcase @cdp128
  Scenario: Login with valid credential
    Given User opens the Applications
    When User enters valid email 'testuser798@gmail.com' into the email field
    And User enters valid password User@123 into the password field
    And User clicks on Login button on page
    Then User should get successfully loggedin

  @negative_testcase, @login
  Scenario Outline: Login with invalid credential
    Given User opens the Applications
    When User gives <condition> in field
    And User clicks on Login button on page
    Then User should get a warning message about credentials mismatch <condition>
    Examples:
      |    condition	 | warningMsg |
      | invalidEmail     |  errorMsg  |
      | invalidPassword  |  errorMsg  |
      | emptyEmail       |  errorMsg  |
      | emptyPassword    |  errorMsg  |
      | emptyCredential  |  errorMsg  |







