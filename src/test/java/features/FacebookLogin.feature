Feature: Facebook home page login


#  “Given” keyword is used to specify a precondition for the scenario.
#  “When” keyword is used to specify an operation to be performed.
#  “Then” keyword is used to specify the expected result of a performed action.
#  “And” keyword is used to join one or more statements together into a single statement.


  Scenario: Home page default login
    Given User is on facebook home page
    And User input username and password
    When User click the login button
    Then User should be logged in