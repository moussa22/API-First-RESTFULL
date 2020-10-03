Feature: To retrieve the users by users id

Scenario: retrieve the user with user id
  Given  user informations id 100L and user name "barath" and user email "t@yahoo.fr"
Then  calls POST "/save"
When the client calls GET "/users/100"
Then the client receives status code of 200
Then the response contains customer name "barath"