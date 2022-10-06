Feature: Get All User at Dummyjson.com
 @Users
  Scenario: Get All User with Valid Path
    Given Get all users with valid path
    When Send request get all users
    Then Status should return 200 OK
    And Get all user json schema validator
 @Users
  Scenario: Get All Users with Invalid Path
    Given Get all users with invalid path
    When Send request get all users invalid path
    Then Status should return 404 Not Found
  @Users
  Scenario: Get All Users with Adding Letters on Path
    Given Get all users with invalid path
    When Send request get all users with adding letters on path
    Then Status should return 404 Not Found
  @Users
  Scenario Outline: Get All Users with Adding Number and Numbers on Path
    Given Get all users with adding <number> on path
    When Send request get all users adding number on path
    Then Status should return 404 Not Found
    Examples:
      |number|
      |1     |
  @Users
  Scenario Outline: Get All Users with Adding Numbers on Path
    Given Get all users with add numbers <numbers> on path
    When Send request get all users adding numbers on path
    Then Status should return 404 Not Found
    Examples:
      |numbers|
      |12345  |
  @Users
  Scenario Outline: Get All Users with Adding Special Characters After Path
    Given Get all users with adding special characters <characters> after path
    When Send request get all users adding special character on path
    Then Status should return 404 Not Found
    Examples:
      |characters|
      |@#%   |



