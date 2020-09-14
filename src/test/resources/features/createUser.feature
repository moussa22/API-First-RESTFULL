Feature: To save the users with users details

  Scenario: client makes call to POST /save to save the user
    Given the user with user id 7L and user name "barath" and user email "t@yahoo.fr"
    When the client calls "/save" with the given details
    Then the client receives status code of 201
    And the response contains user name "barath"