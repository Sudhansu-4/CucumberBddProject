Feature: feature to test login functionality

  @ray
  Scenario: Successful Login with Valid Credentials
    Given User Launch FireFox browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout link
    Then Page title should be "Your store. Login"
    And Close browser

    @Regression

    Scenario Outline: Successful Login with Valid Credentials DDT
      Given User Launch FireFox browser
      When User open URL "https://admin-demo.nopcommerce.com/login"
      And User enters Email as "<email>" and password as "<password>"
      And Click on Login
      Then Page title should be "Dashboard / nopCommerce administration"
      When User click on logout link
      Then Page title should be "Your store. Login"
      And Close browser
      Examples:
       |email | password |
      |admin@yourstore.com|admin|
      |test@yourstore.com|admin|