Feature: Login functionality

  Scenario: Successful login
    Given I am on the login page
    When I enter valid credentials
    And I click the login button
    Then I should see the products page

  Scenario: Login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials
    And I click the login button
    Then I should see an error message

  Scenario: Login with empty fields
    Given I am on the login page
    When I leave the fields empty
    And I click the login button
    Then I should see an error message