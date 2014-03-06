Scenario:
Create template
Given name of current test
When clicks on element with id/name/className 'form1:AddTemplate'
Then wait until all animations on page completed
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with testName
Then wait until all animations on page completed




