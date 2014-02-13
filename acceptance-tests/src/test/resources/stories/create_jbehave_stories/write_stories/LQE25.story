Narrative:
LQE-25: As a template author I want to search for questio nnaire templates so that I
        can quickly find the needed ones.



Scenario:
Given user is on Home page
When the user fills 'form1:table:globalFilter' field with 'd1ftghjklkjhfdsa'
Then wait for '1' sec
Then element with No records found is visible
Then wait for '1' sec
When the user fills 'form1:table:globalFilter' field with 'test'
Then wait for '1' sec
Then element with Test_template is visible
Then wait for '1' sec
When the user fills 'form1:table:globalFilter' field with ''
Then wait for '1' sec