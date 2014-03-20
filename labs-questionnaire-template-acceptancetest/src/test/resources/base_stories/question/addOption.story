Scenario: Add option
Given name of option
When clicks on element with id/name/className 'form2:AddOption'
When in table 'form2:tableOptions' user fills name of new option with <option name>
Then wait until all animations on page completed

