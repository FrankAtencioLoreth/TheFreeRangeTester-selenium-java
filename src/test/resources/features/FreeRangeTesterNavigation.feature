@regression
Feature: Navigation bar
  To see the free range testers pages
  Without login in
  I can click the navigation bar links

  Background: I am on the Free range testers web without logging in
    Given I navigate to landing page

  @sections
  Scenario Outline: I can access to subsections through the navigation bar
    When I go to <section> using the navigation bar
      Examples:
        | section   |
        | Cursos    |
        | Recursos  |
        | Udemy     |
        | Blog      |
        | Mentorías |
        | Academia  |

  @courses
  Scenario: Curses are presented correctly to potential customers
    When I go to Cursos using the navigation bar
    And I select a course

  @plans
  Scenario: The users can select a plan when sign up
    When I select a plan
    Then I can validate the options in the checkout page
