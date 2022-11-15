Feature: n11 Task

  @Nurhayat
  Scenario: n11 Assessment
    Given Navigate to basqar
    When Verify you are on n11 home page
    And Click login
    And Login with valid user name and password
    And Type Samsung into Search Box and click Search button
    And Verify the search results
    And Click second page of the search results and verify the page displayed is the second page
    And Click Add Favorites to the third product in second page
    And Click My Favorites link on top
    And Verify that it is the product that has been just added to favorites
    And Click Delete to remove product from My Favorites
    Then Verify that the product is not in My Favorites link anymore



