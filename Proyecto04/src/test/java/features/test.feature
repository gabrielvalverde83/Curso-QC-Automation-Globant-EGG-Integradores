Feature: PruebaTest
  Scenario Outline: Check wikipedia article displayed for Star Wars Character
    Given I am an user at the Wikipedia WebPage requesting SW character <number>
    When I search the requested character name on Wikipedia search page
    Then I should be able to see the article page correctly displayed for the requested character

    Examples:
      |number|
      |1|
      |2|
      |3|
      |4|
      |5|

  Scenario: request for a random movie from swapi using theStar Wars API
    Given I am an user at the Wikipedia WebPage requesting SW movie
    When I search the requested movie name on Wikipedia search page
    And go to the article page and click on the Edit Link
    Then Check the edit page is displayed correctly, including the matching of the title for the article page

  Scenario: request for a random movie from swapi using theStar Wars API
    Given I am an user at the Wikipedia WebPage requesting SW movie
    When I search the requested movie name on Wikipedia search page
    And go to the article page and click on the Ver Historial Link
    Then Check the edit page is displayed correctly, including the matching of the title for the article page