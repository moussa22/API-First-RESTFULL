Feature: To save the users with users details

  Scenario: client makes call to POST /save to save the user
    Given the user with user id 9L and user name "toto" and user email "t@yahoo.fr"
    When the client calls "/save" with the given details
    Then the client receives status code of 201

  Scenario:  GET /users
    When the client calls "/users"
    Then the response  status code is 200
    Then the user must be  not null

    Examples: