Feature: Search Posts on Dummyjson.com

  Scenario: Search post without parameter
    Given Get search post without parameter
    When Send request get search post empty
    Then Should return 200 OK
    Then Response body should contain 150 post
    And Get search post json Schema Validator

  Scenario: Search post with valid parameter
    Given Get search post with parameter "love"
    When Send request get search post
    Then Should return 200 OK
    And Response body should contain keyword "love"
    And Get search post json Schema Validator

  Scenario: Search post with invalid parameter
    Given Get search post with parameter "apa"
    When Send request get search post
    Then Should return 400 Bad Request