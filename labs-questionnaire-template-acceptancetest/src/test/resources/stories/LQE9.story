Narrative
As a template author I want to add "Paragraph Text" questions to
question groups so that the template meets my needs.

Scenario:
Narrative:
Creating new template
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-9 test'
When clicks on element with id/name/className 'formTemplate:save'

Scenario:
Narrative:
Add section to new template
When in table 'form1:table' user presses 'Edit' in row with 'LQE-9 test'
Then should open page with 'Template Editor' title