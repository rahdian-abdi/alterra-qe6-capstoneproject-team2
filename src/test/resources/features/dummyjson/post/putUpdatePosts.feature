Feature: Put Update Posts on Dummyjson.com

  Scenario Outline: Update post with valid id
    Given  Put update post with valid posts id <id>
    When Send request put update post
    Then Should return 200 OK
    And Response posts body should contain posts title "Buku kita bersama"
    And Put Update Posts json Schema Validator
    Examples:
      |id|
      |1 |
      |92|
      |100|
      |150|

  Scenario: Update post with invalid id
    Given  Put update post with invalid id "tes"
    When Send request put update post
    Then Should return 400 Bad Request
  Scenario: Update post with unregistered id
    Given Put update post with valid posts id 200
    When Send request put update post
    Then Should return 404 Not Found
  Scenario: Update post with registered id and invalid Value
    Given  Put update post with id 1 and invalid value
    When Send request put update post
    Then Should return 400 Bad Request
  Scenario: Update post with unregistered id and invalid Value
    Given  Put update post with unregistered id 200 and invalid value
    When Send request put update post
    Then Should return 404 Not Found
