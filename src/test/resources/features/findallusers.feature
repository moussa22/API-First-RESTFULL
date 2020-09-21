Feature: To find all users in BD

  Scenario: client make call to GET /users
    When the client calls "/users"
    Then the client have success and receives status code of 200
