Feature: Get Posts Comments on Dummyjson.com
  Scenario Outline: Get post comments with valid post id
    Given Get post comments with valid post id <id>
    When Send request get posts comments
    Then Should return 200 OK
    And Response body should contain comments posts id <id>
    And Get Posts Comments json Schema Validator
    Examples:
      |id|
      |1 |
      |92|
      |100|
      |150|

  Scenario Outline: Get post comments with invalid post id
    Given Get post comments with invalid post id "<id>"
    When Send request get posts comments
    Then Should return 400 Bad Request
    Examples:
      |id|
      |tes|
      |ZYG|
      |!@#%|
      |%@#$|

  Scenario Outline: Get post comments with unregistered post id
    Given Get post comments with unregistered post id <id>
    When Send request get posts comments
    Then Should return 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|


