Scenario: Add row to grid
Given name of row
When clicks on element with id/name/className 'form2:cmdEditRow'
Then wait until all animations on page completed
When the user fills 'formAddRow:inpAddRow' field with row name
When clicks on element with id/name/className 'formAddRow:cmdAddRowOk'
Then wait until all animations on page completed

