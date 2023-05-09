
Feature: Amazon Shopping
  Background:
    Given I am on Amazon homepage
    And I search for "samsung mobile"

  @PositiveTest
  @Test
  Scenario Outline: Add item to cart
    Given I am on search results page
    When I click on the first search result
    And I add the <item> to cart
    Then the item should be added to the cart
    Examples:
      | item |
      | Samsung Galaxy S20 |
      | Samsung Galaxy Note 20 |
      | Samsung Galaxy A51 |

#  @NegativeTest
#  Scenario Outline: Add invalid item to cart
#    Given I am on search results page
#    When I click on an invalid search result
#    Then the item should not be added to the cart
#    Examples:
#      | item |
#      | 12345 |
#      | !@#$% |
#      | Samsung Galaxy S20! |

#  @NegativeTest
#  Scenario: Add item with invalid quantity to cart
#    Given I am on product page
#    When I add the item with an invalid quantity to cart
#    Then the item should not be added to the cart

#  @NegativeTest
#  Scenario: Add item with invalid delivery address
#    Given I am on product page
#    When I add the item to cart with an invalid delivery address
#    Then the item should not be added to the cart
#
#  @NegativeTest
#  Scenario: Add item with invalid payment information
#    Given I am on product page
#    When I add the item to cart with invalid payment information
#    Then the item should not be added to the cart

#  @NegativeTest
#  Scenario: Add item with empty quantity
#    Given I am on product page
#    When I add the item to cart with an empty quantity
#    Then the item should not be added to the cart
#
#  @NegativeTest
#  Scenario: Add item with empty delivery address
#    Given I am on product page
#    When I add the item to cart with an empty delivery address
#    Then the item should not be added to the cart
#
#  @NegativeTest
#  Scenario: Add item with empty payment information
#    Given I am on product page
#    When I add the item to cart with empty payment information
#    Then the item should not be added to the cart

  Scenario: Open Amazon Homepage
    Given I am on Amazon homepage
    When I search for "samsung mobile"
    Then the search results should be displayed