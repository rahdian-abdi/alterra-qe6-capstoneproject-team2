Feature: Get All Products on Dummyjson.com
  @positive
  Scenario: Get all products with valid parameter
    Given Get all products from "products" parameter
    When Send request get all products
    Then Should return 200 OK status code
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
    And Get all products from search query JSON schema
  @positive
  Scenario: Get all products with precluded searched parameter
    Given Get all products from search query with "football" keyword
    When Send request get all search products
    Then Should return 200 OK status code
    And Get all precluded products from search query JSON schema
  @positive
  Scenario: Get all products categories with valid parameter
    Given Get all products categories
    When Send request get all categories
    Then Should return 200 OK status code
    And Get all products categories JSON schema