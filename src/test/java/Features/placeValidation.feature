Feature: Validating place APIs

  Scenario Outline: Verify if place is being successfully added
    Given Add place payload "<name>" "<address>" "<language>"
    When user calls "addPlaceAPI" with "POST" http request
    Then the response is success with status code 200
#    And "status" in response body is "OK"
#    And "scope" in response body is "APP"

    Examples:
    |  name  |       address       | language  |
    | myHome | #56, 5th cross road |  Kannada  |