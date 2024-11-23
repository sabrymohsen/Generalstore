Feature: General Store App Automation

  Scenario: Add products to the cart and validate the total
    Given I launch the General Store app
    When I select "Egypt" from the country dropdown
    And I enter "sabrymohsen" as my name
    And I select "Male" as my gender
    And I click on the "Let's Shop" button
    And I add two products to the cart
    Then I should see both products in the cart
    And the total amount should equal the sum of the products

