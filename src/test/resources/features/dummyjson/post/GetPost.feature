Feature: Posts on Dummyjson.com
  Scenario: Get all posts with valid parameter
    Given Get all posts with valid parameter "posts"
    When Send request get all post
    Then Should return 200 OK
    And Response body should contain total post 150
    And Get all posts json Schema Validator
  Scenario Outline: Get single post with valid parameter
    Given Get single post with valid parameter <id>
    When Send request get single post
    Then Should return 200 OK
    And Response body should contain id <id>
    And Get single posts json Schema Validator
    Examples:
    |id|
    |1 |

