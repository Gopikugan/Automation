@Demo
Feature: To Check the login functionality of outlook web mail mail
	Description: This feature is to validate the login functionality of outlook webmail mail


Background: User in Login page
	Given user already in login page


@Regression
Scenario: Verify user able login to application with valid credentails
	When user try to login with valid credentials
		|username				|password	|
		|gopinath.m@prodapt.com	|Kugan@36	|
	Then application should navigate to inbox page
	And verify the title of inbox page
		|title								|
		|Gopinath M - Outlook Web App		|


@Smoke
Scenario Outline: Verify user shoud not login to application with invalid credentails
	When user try to login with invalid credentials "<username>" and "<password>"
	Then verify appropirate error message gets displayed
Examples:
	|username				|password	|
	|gopinath.m@prodapt.com	|Kugan@20	|
	|gopi123.m@prodapt.com	|Kugan@36	|


#@Regression
#Scenario Outline: Verify user able to send a  E-mail
#	Given user logged in to mailbox
#	When user tries to send a email
#	Then appropirate sucess message should display
#Examples:
#		|username				|password	|To Address				|Subject	|Description			|
#		|gopikugan16@gmail.com	|16june95	|gopinath.m@prodapt.com	|Test-Email	|Email via automation	|
		
		
