Feature: Update User feature at Dummyjson.com

  Scenario: Update User with Valid Registered Id
    Given Update user with body data
    When Send request update user by id
    Then Status should return 200 OK
    And Updated user body should return to requested data Jono

    Scenario: Update User with Unregistered Id
      Given Update user with valid body data
      When Send request update user by invalid id
      Then Status should return 404 Not Found
      And Update user unregistered id json schema validator


    Scenario: Update User Registered Id with Empty Body Value
      Given Update user with empty body value
      When Send request update user by id
      Then Status should return 400 Bad Request
      And Update user empty body value json schema validation

    Scenario: Update User with Invalid Path Using Special Character
      Given Update user with special character id body data
      When Send request update user path with special character
      Then Status should return 400 Bad Request
      And Update user special character path json schema validation





