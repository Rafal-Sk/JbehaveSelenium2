Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Login and password on page
Given user <username> with password <passcode> is on product page <url>
When the user clicks button Login
Then the page is displayed <getkeyword>

Examples:
|username|passcode|url|getkeyword|
|lucky|54321qaz|http://the-internet.herokuapp.com/login|Your username is invalid!|