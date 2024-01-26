Feature: Calculate Rental Costs and Frequent Renter Points

  Scenario: Empty Rental
    Given I am an existing customer named "Bob Smith"
    When I rent no movies
    Then my bill is 0.0

  Scenario Outline: Single Movie Rentals
    Given I am an existing customer named <Name>
    When I rent <Movie Title> of <Movie Type> for <Days>
    Then my bill is <Amount>
    Then I earn Frequent Renter <Points>

    Examples: 
      | Name       | Movie Title    | Movie Type    | Days | Amount | Points |
      | "Brigitte" | "Spiderman"    | "Regular"     |    1 |    2.0 |      1 |
      | "Nguyen"   | "Batman"       | "Regular"     |    3 |    3.5 |      1 |
      | "Bill"     | "Wonder Woman" | "New Release" |    1 |    3.0 |      1 |
      | "Lisa"     | "Dunkirk"      | "New Release" |    3 |    9.0 |      2 |
      | "Tori"     | "Babe"         | "Childrens"   |    1 |    1.5 |      1 |
      | "Thomas"   | "Lion King"    | "Childrens"   |    4 |    3.0 |      1 |
