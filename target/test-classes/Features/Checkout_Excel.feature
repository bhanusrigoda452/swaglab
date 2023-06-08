Feature: Checkout_Page_Excel
 
  Scenario Outline: Verify checkout-step-one page functionality with valid data
    Given Chrome is launched and Swaglabs is opened
    Then User navigates to login page
   When User loged into swaglabs with Username "standard_user" and Password "secret_sauce"
    And User add the product to the cart and click on check out page
		Then User fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on Continue button in checkout-step-one page
    Then It navigates to checkout step-two-page
    
   Examples:   
       |SheetName |RowNumber|
       |Sheet1    |        0|
       |Sheet1    |        1|