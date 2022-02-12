Feature: Verify Login functionality

Scenario Outline: Positive test case

Given Enter username as <username>
And Enter Password as <password>
And Click on Submit button
Then Home page should be displayed

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|