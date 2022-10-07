Feature: Delete Posts on Dummyjson.com

  Scenario Outline: Delete a post with valid posts id
    Given  Delete post with valid id <id>
    When Send request delete post
    Then Should return 200 OK
    And Response body should contain true on isDeleted
    And Response body should contain posts id <id>
    And Delete post json Schema Validator
    Examples:
    |id|
    |1 |
    |92|
    |100|
    |150|

  Scenario Outline: Delete a post with invalid posts id
    Given  Delete post with invalid id "<id>"
    When Send request delete post
    Then Should return 400 Bad Request
    Examples:
      |id|
      |tes|
      |xyz|
      |!#$|
      |%#@|

  Scenario Outline: Delete a post with unregistered posts id
    Given  Delete post with unregistered id <id>
    When Send request delete post
    Then Should return 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|