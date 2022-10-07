Feature: Get All Posts on Dummyjson.com
  Scenario: Get all posts with valid parameter
    Given Get all posts with parameter "posts"
    When Send request get all post
    Then Should return 200 OK
    And Response body should contain total posts 150
    And Get all posts json Schema Validator
  Scenario: Get all posts with invalid parameter
    Given Get all posts with parameter "post"
    When Send request get all post
    Then Should return 404 Not Found

