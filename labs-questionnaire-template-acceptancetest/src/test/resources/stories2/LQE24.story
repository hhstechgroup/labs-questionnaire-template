Narrative:
In order to have an ability to edit template 
As a template author
I want to delete questionnaire templates (LQE-24)


Scenario:
User can delete the selected template.
When the user opens the default page
Then wait for element 'form1:table:1:DeleteDialogButton' is visible






Scenario:
Confirmation message is displayed on the delete action.
When clicks on element with id/name/className 'form1:table:1:DeleteDialogButton'
Then wait until all animations on page completed


Scenario:
If deletion is confirmed, the template is removed from the list.

When clicks on element with id/name/className 'form1:table:1:yes'
Then should open page with 'Questionnaire Editor' title
