Feature: Facebook home page login


  Scenario: Home page default login
    Given User is on facebook home page
    And User input username and password
    When User click the login button
    Then User should be logged in