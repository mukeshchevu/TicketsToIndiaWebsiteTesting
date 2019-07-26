@EndToEnd
  Feature: Using rest assured we get userdetails ,register user and update user details

    Scenario:Getting userdata
      Given I have API URL
      When I call above get request API URL
      Then Make sure response status code should return 200
      And Verify that the response has first name Janet

      Scenario: Registering user
        Given I have API URL  and request body
        When I call above post request
        Then Make sure post response status code should return 201
        And Verify the newly created user


        Scenario: Updating user details
          Given I have API URL and existingdata
          When I call above put request
          Then Make sure get response status code should return 200
          And Verify updated user
