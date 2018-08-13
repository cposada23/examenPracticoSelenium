Feature: Shoping
    Scenario: Shop as a guest
        Given Dubai as a place to search for tours
        And choosing one of the tours
        Then i can buy as a gest
    Scenario: Shop as a register user
        Given without the need to be login i can search for tours in Dubai
        And choosing one of the tours from the list
        Then i can buy as a register user