Feature: Get Posts Comments on Dummyjson.com
  Scenario: Get post comments with valid post id
    Given Get post comments with valid post id 5
    When Send request get posts comments
    Then Should return 200 OK
    And Response body should contain comments posts id 5
    And Get Posts Comments json Schema Validator

  Scenario: Get post comments with invalid post id
    Given Get post comments with invalid post id "tes"
    When Send request get posts comments
    Then Should return 400 Bad Request

  Scenario: Get post comments with unregistered post id
    Given Get post comments with unregistered post id 200
    When Send request get posts comments
    Then Should return 404 Not Found


