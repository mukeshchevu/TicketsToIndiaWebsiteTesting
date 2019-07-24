@EndToEnd
  Feature: using rest assured we use get put and post request

    Scenario:i give API URL and get response from API
      Given i have API URL
      When i call above get request API URL
      Then make sure response status code should return 200
      And verify that the response has first name Janet



      Scenario: i give API URL and update data
        Given i have API URL  and request body
        When i call above post request
        Then make sure post response status code should return 201
        And verify the newly created user
