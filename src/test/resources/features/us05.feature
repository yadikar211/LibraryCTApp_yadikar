Feature: As a data consumer, I want to know genre of books are being borrowed the most
  @db @AA05
  Scenario: verify the the common book genre that’s being borrowed
   # Given Establish the database connection
    When I execute query to find most popular book genre.
    Then verify "Action and Adventure" is the most popular book genre