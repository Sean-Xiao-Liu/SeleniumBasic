Feature: Find Dealer
  Scenario Outline: Find dealer through UCL
    Given I am on main carfax page
    And I navigate to find a used car page
    When I click on Find a Dealer button
    Then I choose a "<make>" , "<radius>" and "<zipcode>" to find a dealer and click submit
    Given I am able to see dealer list
    When I click on any dealer page that I want
    Then I able to see cars from specific dealer
    Examples:
      | make  | radius | zipcode |
      | Audi | 50     | 22204   |
      | Audi  | 25     | 22201   |
      | Honda | 100    | 20142   |