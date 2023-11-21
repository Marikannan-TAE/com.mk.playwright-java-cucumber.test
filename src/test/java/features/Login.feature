Feature: Login
  Test Login functionality

  Scenario: Test Login functionality
    Given I navigate to the application
    And I click Login link
    And I enter following login details
      | username | password |
      | admin | password |
    Then I click Log off
