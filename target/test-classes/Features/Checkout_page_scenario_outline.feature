Feature: Checkout_Page
 
  Scenario Outline: Verify checkout-step-one page functionality with valid data
    Given Chrome is launched and Swaglabs is opened
    Then User navigates to login page
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User add the product to the cart and click on check out page
		Then User enters "<firstName>" and "<lastName>" and "<postalCode>"
    And User clicks on Continue button in checkout information page
    Then It navigates to checkout overview page
    
   Examples:   
       |firstName |lastName|postalCode|
       | john     | Anath  |522311    |
       | Geetha   | Ravi   |700156    |
  
   Scenario Outline: Verify checkout-step-one page functionality with invalid data
    Given Chrome is launched and Swaglabs is opened
    Then User navigates to login page
    When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User add the product to the cart and click on check out page
    Then User enters "<firstName>" and "<lastName>" and "<postalCode>"
    And User clicks on Continue button in checkout information page
    Then It shows error message enter postal code
    
   Examples:   
       |firstName|lastName|postalCode|
       | john     | Anath |         |
  		
  	
  
  
  
 