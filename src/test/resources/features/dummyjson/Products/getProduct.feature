Feature: Get Product on Dummyjson.com
  @positive
  Scenario: Get product with registered id
    Given Get product from id 1
    When Send request get single product
    Then Should return 200 OK status code
    And Body response should display id 1
    And Get single product JSON schema
  @negative
  Scenario: Get product with registered id
    Given Get product from id 1000
    When Send request get single product
    Then Should return 404 Not Found status code
    And Body response should display message "not found"
    And Get single product unregistered JSON schema