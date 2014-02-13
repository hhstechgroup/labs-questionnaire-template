
Narrative:
LQE-2
Scenario:
When the user opens the default page
Then the user clicks  button with id  'form1:AddTemplate'
Then wait for '5' sec
When the user fills 'formTemplate:name' field with 'New Name - Template'
Then the user clicks  button with id 'formTemplate:cancel'
Then wait for element 'modalDialogCancel' is visible
Then the user clicks  button with id 'formTemplate:no'
Then the user clicks  button with id 'formTemplate:save'
Then the user opens the default page

LQE-3
Scenario:
When the user opens the default page
Then the user clicks  button with title 'Edit'
When the user fills 'formTemplate:name' field with 'd1ftghjklkjhfdsa'
Then the user clicks  button with id 'formTemplate:save'
Then wait for '10' sec




