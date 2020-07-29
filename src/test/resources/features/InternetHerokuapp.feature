@Internet
  Feature: Internet Herokuapp test suite
    
    @Internet1
    Scenario: Test File Upload
      Given I goto "internet herokuapp" page
      When I click on "File Upload" link
      Then I verify the heading of the page is "File Uploader"
      Then I click on the Choose File button
      And I upload the file
      And I verify file is uploaded

      @Internet2
      Scenario: Test File Download
        Given I goto "internet herokuapp" page
        When I click on "File Download" link
        Then I verify the heading of the page and uploaded file is present
        Then I download the file
        And I wait for 15 sec

        @Internet3
        Scenario: Floating menu
          Given I goto "internet herokuapp" page
          When I click on "Floating Menu" link
          Then I verify the heading of the page is "Floating Menu"
          And I verify "Home","News","Contact" and "About" menus are present
          When I scroll down to the defined pixel of the page
          Then I verify that "Home","News","Contact" and "About" menus are floating
          When I scroll to pixel "2000" of the page
          And I scroll up to the page
          And I wait for 5 sec
          Then I verify that "Home","News","Contact" and "About" menus are floating
          When I scroll to the end of the page
          And I scroll up to the start of the page
          Then I verify that "Home","News","Contact" and "About" menus are floating

          @Internet4
          Scenario: Forgot Password
          Given I goto "internet herokuapp" page
          When I click on "Forgot Password" link
          Then I verify the heading of the page is that "Forgot Password"
          When I enter the email address as "sreekrish28@gmail.com" and I click retrieve password button
          Then I verify that link sent to email

        @Internet5
        Scenario: Drag and Drop
          Given I goto "internet herokuapp" page
          When I click on "Drag and Drop" link
          Then I verify the heading of the page is "Drag and Drop"
          And  I drag "A" and drop it in "B"
          Then I drag "B" and drop it in "A"

       @Internet6
       Scenario: Hovers
         Given I goto "internet herokuapp" page
         When I click on "Hovers" link
         Then I verify the heading of the page is "Hovers"
         When you hover over the image "1" for additional information
         Then I verify that "name" is  and "View Profile" link are displayed

