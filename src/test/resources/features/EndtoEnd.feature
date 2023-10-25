Feature: End to End Feature functionality

   @VerifyShoppingCartss, @EndtoEnd
  Scenario: Verify Amount on Shopping Carts
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total no of Products

  @VerifyProductonShoppingCart, @EndtoEnd
  Scenario: Verify Product name on Shopping Carts
    Given User opens the Applications
    When User Add MacBook and IPhone to Cart
    Then User should Verify Product Name

  @EndtoEnd
  Scenario: verify Product
    Given User opens the Applications
    When User Add Product to Cart
    Then User should Verify Total no of Products


