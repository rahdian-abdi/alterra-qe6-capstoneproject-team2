Feature: Get All Products on Dummyjson.com
  @positive
  Scenario: Get all products with valid parameter
    Given Get all products from "products" parameter
    When Send request get all products
    Then Should return 200 OK status code
    Then Should return key "products"
    And Get all products JSON schema
  @negative
  Scenario: Get all products with invalid parameter
    Given Get all products from "productsxxx" parameter
    When Send request get all products
    Then Should return 404 Not Found status code
  @positive
  Scenario: Get all products with included searched parameter
    Given Get all products from search query with "mobile" keyword
    When Send request get all search products
    Then Should return 200 OK status code
    And Should return any data that contain "mobile"
    And Get all products from search query JSON schema
  @positive
  Scenario: Get all products with precluded searched parameter
    Given Get all products from search query with "football" keyword
    When Send request get all search products
    Then Should return 200 OK status code
    And Should not contain any data
  @positive
  Scenario: Get all products categories with valid parameter
    Given Get all products categories from "categories" parameter
    When Send request get all categories
    Then Should return 200 OK status code
    And Get all products categories JSON schema
  @positive
  Scenario: Get all products from registered categories
    Given Get all products from "smartphones" categories
    When Send request to get all products from categories
    Then Should return 200 OK
    And Should return "smartphones" on the category
    And Get all products from categories JSON schema
  @positive
  Scenario: Get all products from unregistered categories
    Given Get all products from "football" categories
    When Send request to get all products from categories
    Then Should return 200 OK
    And Should not contain any data