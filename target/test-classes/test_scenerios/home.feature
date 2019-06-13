#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: To verify home page scenario

  @tag1
  Scenario: To verify link count on home page
    Given launch "chrome" browser with url as "https://the-internet.herokuapp.com/"
    And verify home page by "title" as "The Internet"
   	And verify link count as 41
    And close browser
    
	
  @tag2
  Scenario Outline: Title of your scenario outline
    Given launch "<browser>" browser with url as "<url>"
    And verify home page by "<verifyby>" as "<titlename>"
   	And verify link count as <count>
    And close browser
    
        Examples: 
      | browser| url                                 | verifyby | titlename  | count|
      | chrome | https://the-internet.herokuapp.com/ | title    |The Internet| 41   |
      | firefox| https://the-internet.herokuapp.com/ | title    |The Internet| 41   |
     
	
	Scenario:
	 Given launch "chrome" browser with url as "https://the-internet.herokuapp.com/"
    And verify home page by "title" as "The Internet"
   And click on "Form Authentication" link on home page
   And pass username as "tomsmith"
   And pass password as "SuperSecretPassword!"
   And click on "Login" button
   
   