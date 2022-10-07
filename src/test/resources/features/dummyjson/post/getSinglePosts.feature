Feature: Get Single Posts on Dummyjson.com
  Scenario Outline: Get single post with valid id
    Given Get single post with parameter <id>
    When Send request get single post
    Then Should return 200 OK
    And Response body should contain id <id>
    And Get single posts json Schema Validator
    Examples:
      |id|
      |1 |
      |92|
      |100|
      |150|

  Scenario Outline: Get single post with String id
    Given Get single post with parameter "<id>"
    When Send request get single post
    Then Should return 400 Bad Request
    Examples:
      |id|
      |tes|
      |ZYG|


  Scenario Outline: Get single post with Special Char id
    Given Get single post with parameter "<id>"
    When Send request get single post
    Then Should return 400 Bad Request
    Examples:
      |id  |
      |!@#%|
      |%@#$|
  Scenario Outline: Get single post with unregistered id
    Given Get single post with parameter <id>
    When Send request get single post
    Then Should return 404 Not Found
    Examples:
      |id |
      |200|
      |151|
      |6154|
      |1356|
