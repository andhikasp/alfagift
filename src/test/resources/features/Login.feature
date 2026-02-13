Feature: Login Scenario
  @PositiveTest
  Scenario: Success Login using valid phone number and valid password
    Given I am on the login page
#    When I login with phone number "085697589199"
    And I Click Masuk
    And I fill the password "Baqdhat25"
    And I Click Masuk ke beranda
    Then I successfully login




