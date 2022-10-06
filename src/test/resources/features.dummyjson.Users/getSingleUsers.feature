Feature: Get Single User at Dummyjson.com

  Scenario Outline: Get Single User with Valid Registered Id (1-3) and (10-30)
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status should return 200 OK
    And Response body should contain <id> <firstName> <lastName> <maidenName>
    And Get single user json schema validator
    Examples:
    |id|   firstName   | lastName  | maidenName  |
    |1 |    Terry      | Medhurst  |  Smitham    |
    |2 |    Sheldon    | Quigley   |  Cole       |
    |3 |    Terrill    | Hills     |  Hoeger     |
    |10|    Eleanora   | Price     |  Cummings   |
    |20|    Lenna      | Renner    |  Schumm     |
    |30|    Maurine    | Stracke   |  Abshire    |

  Scenario Outline: Get Single User with Valid Random Registered Id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status should return 200 OK
    And  Response body should contain <id> <firstName> <lastName> <maidenName>
    And  Get single user json schema validator
    Examples:
        |id|   firstName   | lastName   |  maidenName   |
        |27|   Piper       | Schowalter |  Wuckert      |
        |66|   Terrence    | Koelpin    |  Nienow       |
        |73|   Clotilde    | Larson     |  Zboncak      |








