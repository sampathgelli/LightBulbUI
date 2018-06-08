Feature: Qantas Frequent Flyer
  As a Valid User
  I want to open qantas frequent flyer
  So that i can signup for QFF.

  @Smoke
  Scenario Outline: I want to sign up for QFF program

    Given the application url
    And setAllData as country as "<country>" title as "<title>" gender as "<gender>" firstname as "<firstName>" lastName as "<lastName>" prefMethod as "<preferredmethod>" mobile number as "<mobilenumber>"     type as "<addresstype>" addressline as "<addressline>" second addressline as "<secondline>" suburb as "<suburb>" state as "<state>" postcode as "<postcode>" email as "<email>" confirm email as "<confirmEmail>" birth day as "<birthday>" birth month as "<month>" birth year as "<year>" maiden name as "<maidenName>" pin as "<pin>" holdername as "<cardholdername>" cardnumber as "<cardNumber>" expiry date as "<expMonth>" expiry year as "<expYear>" CVV as "<cvv>"
    And register to the appliation with the user country as "<country>" title as "<title>" gender as "<gender>" firstname as "<firstName>" lastName as "<lastName>"
    And phone details as "<preferredmethod>" mobile number as "<mobilenumber>"
    And enter address type as "<addresstype>" addressline as "<addressline>" second addressline as "<secondline>" suburb as "<suburb>" state as "<state>" postcode as "<postcode>"
    And enter email as "<email>" confirm email as "<confirmEmail>"
    And enter the birth day as "<birthday>" birth month as "<month>" birth year as "<year>" maiden name as "<maidenName>"
    And enter the pin as "<pin>"
    And Accept conditions
    And enter card holdername as "<cardholdername>" cardnumber as "<cardNumber>" expiry date as "<expMonth>" expiry year as "<expYear>" CVV as "<cvv>"

  @WIP
    Examples: Valid Data
      | country   | title | gender | firstName | lastName | preferredmethod | mobilenumber | addresstype | addressline        | secondline | suburb     | state          | postcode | email         | confirmEmail  | birthday | month | year | maidenName | pin  | cardholdername | cardNumber       | expMonth | expYear | cvv |
      | Australia | Mr    | Male   | Test      | Test     | Mobile          | 411111111    | Home        | 20 Libarator Drive | Point cook | Point Cook | Victoria (VIC) | 3030     | test@test.com | test@test.com | 11       | Apr   | 1981 | maidenname | 8643 | Sampath        | 4111111111111111 | 02       | 20    | 123 |

  @SIT
    Examples: Valid Data
      | country   | title | gender | firstName | lastName | preferredmethod | mobilenumber | addresstype | addressline        | secondline | suburb     | state          | postcode | email         | confirmEmail  | birthday | month | year | maidenName | pin  | cardholdername | cardNumber       | expMonth | expYear | cvv |
      | Australia | Mr    | Male   | Test      | Test     | Mobile          | 411111111    | Home        | 20 Libarator Drive | Point cook | Point Cook | Victoria (VIC) | 3030     | test@test.com | test@test.com | 11       | Apr   | 1981 | maidenname | 8643 | Sampath        | 4111111111111111 | 02       | 20    | 123 |
