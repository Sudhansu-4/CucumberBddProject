Feature: feature to add new customer
Background: Steps common for all scenarios
  Given User Launch FireFox browser
  When User open URL "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and password as "admin"
  And Click on Login
  Then User can view Dashboard
  @Sanity
  Scenario: Add New Customer

    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new Button
    Then User can view Add new customers page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close browser
    @Regression
  Scenario: Search Customer by email

      When User click on customers Menu
      And click on customers Menu Item
      And Enter customer Email
      When When click on Search Button
      Then User should found in search table
      And Close browser
    @Regression
    Scenario: Search Custromer by Name

      When User click on customers Menu
      And click on customers Menu Item
      And Enter Customer FirstName
      And Enter Customer LastName
       When When click on Search Button
      Then User should found Name in the search table
      And Close browser



