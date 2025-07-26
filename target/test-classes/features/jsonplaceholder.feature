Feature: JSONPlaceholder API

  Scenario: Retrieving all posts
    Given that the JSONPlaceholder API is available
    When send a request to the POST endpoint to posts
    Then endpoint will return a status code 200
    And response should contain a list of posts

  Scenario: Send PUT request to a GET-only endpoint
    Given that the JSONPlaceholder API is available
    When send a PUT request to posts
    Then endpoint will return a status code 404
    And response must contain a message indicating that the method is not allowed or reporting that it was not found
