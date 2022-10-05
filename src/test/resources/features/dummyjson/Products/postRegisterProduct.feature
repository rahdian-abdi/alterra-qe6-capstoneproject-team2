Feature: Post Register Product on Dummyjson.com
  Scenario: Post register product with valid parameter
    Given Post register product valid parameter
    When Send request post product
    Then Should return 200 OK or 201 Created status code
    And Post register product valid parameter JSON schema