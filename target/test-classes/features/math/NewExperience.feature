Feature: NewExperience

  Scenario: Create Account
    Given I am a new user
    When I create an account
    Then it was registered
     
  Scenario: Sign In
    Given I want to log in with ycastelblancij@gmail.com 123456789
    When I enter my account
    Then I find my information
    
  Scenario: Order
    Given I want to place an order
    When  I complete the order
    Then  The order is generated