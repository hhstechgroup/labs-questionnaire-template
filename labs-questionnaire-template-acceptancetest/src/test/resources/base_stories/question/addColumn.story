Scenario: Add column to grid
Given name of column
When clicks on element with id/name/className 'form2:cmdEditCol'
Then wait until all animations on page completed
When the user fills 'formAddCol:inpAddCol' field with column name
When clicks on element with id/name/className 'formAddCol:cmdAddColOk'
Then wait until all animations on page completed

