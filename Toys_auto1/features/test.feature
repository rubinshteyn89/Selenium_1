Feature: Toys R Us


Scenario: Login

    Then I Navigate to Login
    Then Log in
@test1
Scenario: Add First Item to cart

    Then I select categories Age and Big Kids
    Then Loop1
    Then Close Driver
    #Then I select the Toy
    #Then click the pinterest icon
    #Then switch to new window
    #Then close window
  #  Then I click cartAddition
  #  Then I have 1

Scenario: Add Second Item to cart

    Then I select next categories Brand and LEGO
    Then I select Lego Fusion
    Then I select the Toy
    Then I click cartAddition
    Then I have 2

Scenario: Add Third Item to cart via search

    Then I search for Transform
    Then I select the Toy
    Then I click cartAddition
    Then I have 3

Scenario: Remove Items from Cart

    Then Open Cart
    Then remove-3 Items
    Then remove-2 Items
    Then remove-1 Items
    Then I have 0
    Then I Sign Out from my account

Scenario: Close Driver (temp)

    Then Close Driver temp










