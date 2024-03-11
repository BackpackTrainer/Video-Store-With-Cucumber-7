Feature: Calculate Rental Costs and Frequent Renter Points

  User Story:
  As a Video Store Owner, I want to calculate
  my customers fees and frequent renter points accurately so that my customers are not dissatisfied

  Business Rules:
  For Regular movies, the fee is $2.00 for the first two days and $1.50 per day thereafter
  For New Release movies, the charge is $3.00 per day
  For Children's movies, the fee is $1.50 for the first 3 days and then $1.50 per day thereafter

  1 Frequent Renter Point is awarded for each movie rental regardless of movie type or duration
  1 additional Frequent Renter Point is awarded if the rental is longer than 1 day and the movie is a new release

  Acceptance Criteria
  Successfully calculate the fees for renting a single movie of each type for various number of days
  Successfully calculate the fee for renting multiple movies (at least one of each type)
  Successfully calculate the frequent renter points for single and multiple movie rentals of all types and various durations

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
      | "Thomas"   | "Lion King"    | "Childrens"   |    5 |    4.5 |      1 |

  @MultipleMovieRental
  Scenario: Multiple movie rental
    Given I am an existing customer named "Bill"
    When I rent "Spiderman" of "Regular" for 2
    When I rent "Wonder Woman" of "New Release" for 2
    When I rent "Argyle" of "New Release" for 1
    Then my bill is 11.0
    Then I earn Frequent Renter 4