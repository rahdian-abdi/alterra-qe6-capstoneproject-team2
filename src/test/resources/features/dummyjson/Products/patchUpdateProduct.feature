Feature: Patch Update Product on Dummyjson.com
  Scenario: Patch update product with registered id
    Given Patch update product with id 1
    When Send request patch product
    Then Should return 200 OK or 204 No Content status code
    And Should return "1" on id
    And Update patch product registered id JSON schema

  Scenario: Patch update product with unregistered id
    Given Patch update product with id 1000
    When Send request patch product
    Then Should return 404 Not Found status code
    And Should return "not found" on message
    And Update patch product unregistered id JSON schema