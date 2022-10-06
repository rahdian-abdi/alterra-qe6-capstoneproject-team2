Feature: Post Register Product on Dummyjson.com
  @positive
  Scenario: Post register product with valid parameter
    Given Post register product
    When Send request post product
    Then Should return 200 OK or 201 Created status code
    And Post register product valid parameter JSON schema
  @negative
  Scenario: Post register product with invalid parameter
    Given Post register product
    When Send request post product invalid parameter
    Then Should return 404 Not Found status code
  @negative
  Scenario: Post register product with incomplete body request
    Given Post register product incomplete body request
    When Send request post product
    Then Should return 400 Bad Request status code
  @negative
  Scenario: Post register product with empty body request
    Given Post register product empty body request
    When Send request post product
    Then Should return 400 Bad Request status code
  @negative
  Scenario: Post register product with invalid body request
    Given Post register product invalid data type body request
    When Send request post product
    Then Should return 400 Bad Request status code
