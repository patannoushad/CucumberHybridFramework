@all @abc
Feature: End to End Feature functionality

   @VerifyShoppingCarts @EndToEnd
  Scenario: Verify Amount on Shopping Carts
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total no of Products

  @VerifyProductionShoppingCart @EndToEnd
  Scenario: Verify Product name on Shopping Carts
    Given User opens the Applications
    When User Add MacBook and IPhone to Cart
    Then User should Verify Product Name

  @EndToEnd
  Scenario: Verify Product
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total no of Products


