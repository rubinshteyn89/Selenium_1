Feature: Google Search

  Scenario: Google Search in chrome
    Given I have Google open
    When I click on the Search Field and input "text"
    And I click the search button
    Then I can click on the first search result

