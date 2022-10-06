Feature: Create New Posts on Dummyjson.com
  Scenario: Create new post with valid user id
    Given Post new post with valid user id
    When Send request post new post
    Then Should return 200 OK
    And Response body should contain posts id 151 and title "Buku kita bersama"
    And Post new posts json schema validator

  Scenario: Create new post with invalid user id
    Given Post new post with invalid user id
    When Send request post new post
    Then Should return 400 Bad Request

  Scenario: Create new post without user id
    Given Post new post without user id
    When Send request post new post
    Then Should return 400 Bad Request

  Scenario: Create new post with unregistered user id
    Given Post new post with unregistered user id
    When Send request post new post
    Then Should return 404 Not Found

  Scenario: Create new post with registered user id  and empty value
    Given Post new post registered user id  and empty value
    When Send request post new post
    Then Should return 400 Bad Request

  Scenario: Create new post with unregistered user id and empty value
    Given Post new post unregistered user id  and empty value
    When Send request post new post
    Then Should return 404 Not Found
