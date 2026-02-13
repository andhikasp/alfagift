Feature: Shopping
  @PositiveTest
  Scenario: Success search and view product detail
    Given I am already logged in
    When I click field search
    And I fill on search box "Ultra Milk Coklat"
    And I click button search on keyboard
    And I click the specific product "Ultra Milk Susu UHT Coklat Kotak 200 ml"
    Then I should see the product detail page



