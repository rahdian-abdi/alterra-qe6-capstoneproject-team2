Feature: Patch Update Posts on Dummyjson.com

  Scenario: Patch Update post with valid Posts id
    Given  Patch update post with valid id 1
    When Send request patch update post
    Then Should return 200 OK
    And Response body should contain post id 1
    And Patch Update posts json schema validator

  Scenario: Patch Update post with invalid Posts id
    Given  Patch update post with invalid id "tes"
    When Send request patch update post
    Then Should return 400 Bad Request

  Scenario: Patch Update post with unregistered Posts id
    Given  Patch update post with unregistered id 200
    When Send request patch update post
    Then Should return 404 Not Found

