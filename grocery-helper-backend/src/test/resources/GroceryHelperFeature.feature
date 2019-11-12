#Author: Bijoy Baral (bijoy.on.java@gmail.com)
#This is for demo purpose(possible if time permitted).
# Similarily for edit/delete scenrarios can be written(all positive and -ve scenarios)
@tag
Feature: Add, edit, delete and list groceries

  @tag1
  Scenario: Client makes call to GET /grocery-helpers/grocerie
    When client calls the GET /grocery-helpers/grocerie
    Then the client receives status code of 200
    And client receives grocery items
      | id | category | description |
      |    |          |             |

  @tag2
  Scenario: Client makes call to GET /grocery-helpers/groceries/{category} to get list of groceries matching the category
    When client calls the GET grocery-helpers/groceries/{category}
    Then the client receives status code of 200
    And client receives grocery items
      | id | category | description |
      |    |          |             |

