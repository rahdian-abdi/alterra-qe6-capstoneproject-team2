Feature: Delete Product on Dummyjson.com
  Scenario: Delete product with registered id
    Given Delete product with id 1
    When send request delete product
    Then Should return 200 OK or 204 No Content status code
    And Should display deleted status "true"
    And Delete product JSON schema

  Scenario: Delete product with unregistered id
    Given Delete product with id 1000
    When send request delete product
    Then Should return 404 Not Found status code
    And Should return "not found" on message
    And Delete product unregistered JSON schema

  Scenario: Delete product with invalid id
    Given Delete product with id "#####"
    When send request delete product
    Then Should return 404 Not Found status code