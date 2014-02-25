As a template author I want to clone questionnaire templates so that I can
quickly create new forms based on the existing ones.
Scenario:
Narrative:
User can copy the existing template.

Given saved 'http://localhost:8080/questionnaire-template-web-1.0-SNAPSHOT/' link
When the user opens saved link
Then wait for element 'form1:table:0:Clone' is visible
When clicks on element with id/name/className 'form1:table:0:Clone'
Then wait until all animations on page completed
Then should open page with 'Questionnaire Editor' title

Scenario:
Narrative:
Copy of the template is created with all
template content and displayed in the list.
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:cancel'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:yes'
Then wait until all animations on page completed
When clicks on element with id/name/className 'form1:table:1:btnEdit'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:cancel'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:yes'
Then wait until all animations on page completed
