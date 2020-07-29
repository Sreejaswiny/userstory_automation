@costco
  Feature: Costco test suite

    @costco1
    Scenario: Test out of stock items
      Given I goto "costco" page
      When I search for "Kitchen Aid Food Processor" item
      Then I click on the item "KitchenAid 9 Cup Food Processor Plus"
      And I verify the availability of item

    @costco2
    Scenario: Test in stock items
      Given I goto "costco" page
      When I search for "Kitchen Aid Stand Mixer" item
      Then I click on the item "KitchenAid Professional Series 6 Quart Bowl Lift Stand Mixer with Flex Edge"
      And I verify the availability of item

    @costco3
    Scenario: Test in or stock items
      Given I goto "costco" page
      When I search for "Kitchen Aid Grill" item
      Then I click on the item "KitchenAid 2-Burner Grill"
      And I verify the availability of item