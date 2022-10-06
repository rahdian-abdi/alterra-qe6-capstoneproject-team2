Feature: Update Product on Dummyjson.com
  Scenario: Update product with registered id
    Given Update product on id 1
    When Send request update product
    Then Should return 200 OK or 204 No Content status code
    And Should return "1" on id
    And Update product registered id JSON schema

  Scenario: Update product with unregistered id
    Given Update product on id 1000
    When Send request update product
    Then Should return 404 Not Found status code
    And Should return "not found" on message
    And Update product unregistered id JSON schema

  Scenario: Update product with invalid parameter
    Given Update product on parameter "productxxx"
    When Send request update product invalid parameter
    Then Should return 404 Not Found status code
    And Should return "not found" on message

  Scenario: Update product with empty body request
    Given Update product on id 1 and empty request body
    When Send request update product
    Then Should return 400 Bad Request status code

  Scenario: Update product with invalid id
    Given Update product on id "#####"
    When Send request update product invalid id
    Then Should return 404 Not Found status code