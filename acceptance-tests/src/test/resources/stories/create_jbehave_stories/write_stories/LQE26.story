Narrative:
LQE-26: As a template author I want to export questionnaire templates.

Scenario:
Given user is on Home page
When the user checks first template
When the user clicks on first element with className 'ui-menubutton' with text 'Options'
When the user clicks on first element with className 'ui-menuitem' with text 'Export'
Then wait for '2' sec
