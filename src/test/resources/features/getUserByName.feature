Feature: To retrieve the user  by Name
  Scenario: retrieve the user with user name
When the client calls GET "/user/byName" with customer name as "barath" in query param
Then the client receives status code of 200
And the response contains customer name "barath"
