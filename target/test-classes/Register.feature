@all @register
Feature:  Register functionality

  @register
  Scenario Outline: Registration with Negative scenario
    Given User opens the Applications
    When User enter <condition> in field
    Then User should get a warning message about credential mismatch <condition>
    Examples:
      |    condition	 |
      |      TC001       |
      |      TC002       |
      |      TC003       |



