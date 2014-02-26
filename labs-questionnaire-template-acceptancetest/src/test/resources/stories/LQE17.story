Scenario:
When the user opens the default page
Then wait for element 'form1:table:1:btnEdit' is visible
When clicks on element with id/name/className 'form1:table:1:btnEdit'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'GROUP_1'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then should open page with 'Question Editor' title
When clicks on element with id/name/className 'form:selectOneMenu_label'
When choose 'FILEUPLOAD' from drop-down
When 'questionForm:form4:fileupload:qtext' field with 'HELP MEE!! TEAM A KILLS ME!!'
When clicks on element with id/name/className 'buttons:savequestion'
Then should open page with 'Template Editor' title



