Feature: ITV HUB (Login Page)

  Scenario: Login into ITV Hub
    Given Open the ITV Homepage
    When Click the Sign-in Button
    And Enter the Email and Password
    And Click the Sign-In Button
    And Verify the NavBar-Name same as User-FirstName
    And Verify the ITV Channels are displayed
    And Click on Shows from NavBar
    And Count and print all the Shows that start with A
    Then Click on Sign-Out Button
