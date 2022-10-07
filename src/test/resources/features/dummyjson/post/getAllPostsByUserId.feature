Feature: Get all posts by user id on Dummyjson.com
  Scenario: Get all posts with valid user id
    Given Get all posts with valid user id 5
    When Send request get all posts
    Then Should return 200 OK
    And Response body should contain user id 5
    And Get all posts by user id json Schema Validator
  Scenario: Get all posts with invalid user id
    Given Get all posts with invalid user id "tes"
    When Send request get all posts
    Then Should return 400 Bad Request
  Scenario: Get all posts with unregistered user id
    Given Get all posts with unregistered user id 200
    When Send request get all posts
    Then Should return 404 Not Found


