Feature: Get All Products on Dummyjson.com
  Scenario: Get all products with valid parameter
    Given Get all products from "products" parameter
    When Send request get all products
    Then Should return 200 OK status code
    And Get all products JSON schema