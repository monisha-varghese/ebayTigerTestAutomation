@component:ui
@product:ebay
@search
Feature: Search products
  In order for customers to view products
  As a online customer
  I want to search for the products

  Scenario: Search for top 5 brands in Electronics
    Given I launch ebay online
    When I login in ebay
    And I go to all electronics section
    And I go to Laptop And Tablet and select Apple products
    And I select a product
    And click on buy now


