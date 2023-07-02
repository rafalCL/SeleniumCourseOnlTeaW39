Feature: Search phrase with Duck Duck Go
Scenario: Successful search phrase with https://duckduckgo.com/
Given https://duckduckgo.com/ opened in web browser
When Phrase 'Faraon' entered in search input box
And Search button clicked
Then First 3 results contain phrase 'Faraon'
