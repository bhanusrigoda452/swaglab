Feature: Checkout page2

  Scenario: Verify  navigation of checkout information page
    Given Chrome is launched and swaglabs is opened
    Then User navigates to login page
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User Go cart page and click on checkout page
    Then User navigates to checkout page

  Scenario: Verify  UI of checkout information page
    Given Chrome is launched and swaglabs is opened
    Then User navigates to login page
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User Go cart page and click on checkout page
    And User entered firstname "Bhanu",lastname "sri" and zipcode "53211" 
    And click on continue button of checkout information page
    Then It shows elements of checkout overview page

  Scenario: Verify functionality in checkout overview page(Finish button is clickable)
    Given Chrome is launched and swaglabs is opened
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User Go cart page and click on checkout page
		And User entered firstname "Bhanu",lastname "sri" and zipcode "53211" 
    And click on continue button of checkout information page
    When User clicks on Finish button
    Then User navigates to Checkout complete page

  Scenario: Verify functionality of product purchase
    Given Chrome is launched and swaglabs is opened
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User Go cart page and click on checkout page
    And User entered firstname "Bhanu",lastname "sri" and zipcode "53211" 
    And click on continue button of checkout information page
    And User clicks on Finish button
    Then User navigates to Checkout complete page
    When User clicks on Back Home button
    Then User navigates to Products list page
