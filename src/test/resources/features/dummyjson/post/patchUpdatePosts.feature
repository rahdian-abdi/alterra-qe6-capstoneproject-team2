Feature: Patch Update Posts on Dummyjson.com

  Scenario Outline: Patch Update post with valid Posts id
    Given  Patch update post with valid id <id>
    When Send request patch update post
    Then Should return 200 OK
    And Response posts body should contain posts title "<title>"
    And Patch Update posts json schema validator
    Examples:
    |id|title|
    |1 |Buku kita bersama|

  Scenario: Patch Update post with invalid Posts id
    Given  Patch update post with invalid id "tes"
    When Send request patch update post
    Then Should return 400 Bad Request

  Scenario: Patch Update post with unregistered Posts id
    Given  Patch update post with unregistered id 200
    When Send request patch update post
    Then Should return 404 Not Found

