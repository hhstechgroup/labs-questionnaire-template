Narrative:
As a template author I want to create new questi
onnaire templates so that I can use them.

Scenario:
User can create a new template by
clicking Add New Template.
User can specify the name for the
template (alphanumeric
symbols, spaces,
dashes).
User can save the template.
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-2 test'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:save'
Then in table 'form1:table' there is a row with 'LQE-2 test'


Scenario:
User can save the template, or cancel
saving.
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-2 test cancel'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then in table 'form1:table' there is not a row with 'LQE-2 test cancel'



