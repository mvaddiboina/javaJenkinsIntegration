Feature: Place an order

  Scenario: Login and place an order1
    Given I am login into the website
    When I add an item to car
    And fill the personal information
    And I place order with provided data
    Then I see order is placed successfully

  Scenario: Login and place an order2
    Given I am login into the website
    When I add an item to car
    And fill the personal information
    And I place order with provided data
    Then I see order is placed successfully

