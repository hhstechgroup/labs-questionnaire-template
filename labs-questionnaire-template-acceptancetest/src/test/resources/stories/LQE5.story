Narrative:
As a template author I want to remove sections
from questionnaire templates so that the forms
meet my needs.

Scenario:
Narrative:
User can delete the added section on the
template creation form.
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-5 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayDelete'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Scenario:
Narrative:
Removed on creation form section is not
displayed in the template.
When in table 'form1:table' user presses 'Edit' in row with 'LQE-5 test'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page

Scenario:
Narrative:
User can delete the added section on the
template editing form.
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 2'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayDelete'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Scenario:
Narrative:
Removed on editing form section is not
displayed in the template.
When in table 'form1:table' user presses 'Edit' in row with 'LQE-5 test'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page



