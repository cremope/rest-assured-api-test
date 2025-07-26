Feature: Cat breeds API testing

  # ========================
  # Happy path
  # ========================

  Scenario: Retrieving all cat breeds
    Given that the Cat Facts API is available
    When send a request to the GET endpoint to breeds without a value specified in the parameter limit
    Then endpoint will return a status code 200
    And response should contain a list of breeds

  Scenario: Retrieving a standard list of cat breeds
    Given that the Cat Facts API is available
    When send a request on the GET endpoint to breeds with the value 1 in the parameter limit
    Then endpoint will return a status code 200
    And response must contain a list of breeds with 1 cat breed

  Scenario: Retrieving more than one breed of cat
    Given that the Cat Facts API is available
    When send a request on the GET endpoint to breeds with a value greater than 1 in the parameter limit
    Then endpoint will return a status code 200
    And response must contain a list of breeds with the quantity specified in the parameter limit

  # ========================
  # Sad path
  # ========================

  Scenario: Send POST request to a GET-only endpoint
    Given that the Cat Facts API is available
    When send a POST request to breeds
    Then endpoint will return a status code 404
    And response must contain a message indicating that the method is not allowed or reporting that it was not found
