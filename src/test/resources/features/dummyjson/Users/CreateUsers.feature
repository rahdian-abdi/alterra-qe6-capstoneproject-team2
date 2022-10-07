Feature: Create user from Dummyjson.com

  Scenario: Create user with body data
    Given Create user with valid body data
    When Send request create user
    Then Status should return 200 OK
    And body response should return to unused id 101 with body data
    And Create user with body data json schema validator

  Scenario: Create User with Empty Value Body Data
    Given Create user with empty body data
    When Send request create user
    Then Status should return 400 Bad Request

  Scenario: Create User with Registered Id
    Given Create user with valid registered id on body data
    When Send request create user
    Then Status should return 200 OK
    And Body should return to unused id 101 automatically with body data
    And Create user with valid registered id json schema validation

  Scenario: Create User with Special Character Id
    Given Create user with special character in on body data
    When Send request create user
    Then Status should return 200 OK
    And Body should return to unused id 101 automatically with body data
    And Create user with special character json schema validation

  Scenario: Create User with Empty Id Value on Body Data
    Given Create user with empty id on body data
    When Send request create user
    Then Status should return 200 OK
    And Body should return to unused id 101 automatically with body data
    And Create user with empty id json schema validation

