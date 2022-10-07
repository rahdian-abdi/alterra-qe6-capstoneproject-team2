Feature: Delete Posts on Dummyjson.com

  Scenario: Delete a post with valid id
    Given  Delete post with valid id 1
    When Send request delete post
    Then Should return 200 OK
    And Response body should contain true on isDeleted
    And Delete post json Schema Validator

  Scenario: Delete a post with invalid id
    Given  Delete post with invalid id "tes"
    When Send request delete post
    Then Should return 400 Bad Request
  Scenario: Delete a post with unregistered id
    Given  Delete post with unregistered id 200
    When Send request delete post
    Then Should return 404 Not Found