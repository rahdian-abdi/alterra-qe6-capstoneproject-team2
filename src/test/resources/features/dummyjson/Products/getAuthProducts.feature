Feature: Get All Authorization Products on Dummyjson.com
  Scenario: Get all product with valid token
    Given Get all product with token and parameter "auth"
    When Send request get all product with token
    Then Should return 200 OK status code
    And Get all products JSON schema

  Scenario: Get all product with invalid token
    Given Get all product with invalid token and parameter "auth"
    When Send request get all product with token
    Then Should return 401 Unauthorized or 500 Bad Servers status code
    And Should return message contain "invalid" token or signature

  Scenario: Get all product with expired token
    Given Get all product with expired token and parameter "auth"
    When Send request get all product with token
    Then Should return 401 Unauthorized or 500 Bad Servers status code
    And Should return message contain "Expired" token or signature
