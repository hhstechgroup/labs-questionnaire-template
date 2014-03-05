Scenario:
Create template
Given name of current test
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with testName
Then wait until all animations on page completed




