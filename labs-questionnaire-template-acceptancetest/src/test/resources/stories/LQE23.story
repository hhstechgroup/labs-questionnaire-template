Narrative:
In order to have an ability to edit template 
As a template author
I want to clone questionnaire templates (LQE-23)


Scenario:
User can copy the existing template.
When the user opens the default page
Then wait for element 'form1:table:0:Clone' is visible
When clicks on element with id/name/className 'form1:table:0:Clone'
When the user fills 'form1:table:globalFilter' field with 'clone'
Then verify that in table 'form1:table' is displayed less than or equal '1' elements per page
Then wait until all animations on page completed
When the user fills 'form1:table:globalFilter' field with ''
Then should open page with 'Questionnaire Editor' title

Scenario:
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
Then element 'formTemplate:name' has attribute value that contains 'clone'
When clicks on element with id/name/className 'formTemplate:cancel'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:yes'
Then wait until all animations on page completed
