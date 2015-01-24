Feature: features


Scenario: Login

    Then Navigate to Login
    Then Log in

Scenario: Add First Item to cart

    Then I select categories Age and Big Kids
    Then I select img of the Toy
    Then I click cartAddition
    Then I have 1

Scenario: Add Second Item to cart

    Then I select next categories Brand and LEGO
    Then I select Lego Fusion
    Then I select img of the Toy
    Then I click cartAddition
    Then I have 2

Scenario: Add Third Item to cart via search

    Then I search for Hasbro
    Then I select img of the Toy
    Then I click cartAddition
    Then I have 3

Scenario: Remove Items from Cart

    Then Open Cart
    Then remove-3 Items
    Then remove-2 Items
    Then remove-1 Items
    Then I have 0
    Then Log out with Sign Out button

Scenario: Close Driver (temp)

    Then Close Driver temp










