Scenario:
When the user opens the default page
Then wait for element 'form1:table:1:btnEdit' is visible
When clicks on element with id/name/className 'form1:table:1:btnEdit'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'GROUP_1'
When clicks on element with id/name/className 'ui-icon-triangle-1-e'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Question 2'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayDelete'
Then wait until page content animations completed

