Scenario: Open default page

When the user opens the default page
Then the user is brought to the page with 'PrimeFaces - ShowCase' title

Scenario: Change checkbox status

When the user clicks link with text 'BooleanButton'
And press 'Submit' button
Then wait for element 'form:dialog' is visible
When the user close popup with id 'form:dialog'