@Test
Feature: you have to get the results in ticketstoindia page
  you need to get number of flights from london heathrow to mumbai

#Scenario:login to ticketstoindia
 # Given i am in home page
  #When i enter destination details
  #And click search button
 #Then results should get displayed

  Scenario: login to ticketstoindia
    Given i am in home page "https://www.ticketstoindia.co.uk/"
    When  i enter destination details
     | flyFrom    |  flyTo         | noOfAdults| noOfChildren|noOfInfants|classType|
     | London Heathrow     |  Mumbai | 2        |1           |1           |Economy |

    And click search button
    Then results should get displayed