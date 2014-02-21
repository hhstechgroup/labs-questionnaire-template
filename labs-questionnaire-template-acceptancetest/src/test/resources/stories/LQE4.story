Narrative:
In order to have an ability to edit template 
As a template author
I want to add new sections to questionnaire templates (LQE-4)

Scenario:
Narrative:
User can add a new section to the
template on the template
creation form.
User can save the template with the
added section.
Given saved 'http://localhost:8080/questionnaire-template-web-1.0-SNAPSHOT/' link
When the user opens saved link
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-4 test save'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When the user fills 'form1:table:globalFilter' field with 'LQE-4 test save'
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then should open page with 'Questionnaire Editor' title

Scenario:
Narrative:
User can add a new section to the
template on the template
editing form.
User can save the template with the
added section.
When the user fills 'form1:table:globalFilter' field with 'LQE-4 test save'
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then should open page with 'Questionnaire Editor' title

Scenario:
Narrative:
User can enter some alphanumeric text for
the section name.

Scenario:
Narrative:
Adding new section to template and canceling
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-4 test cancel'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When the user fills 'form1:table:globalFilter' field with 'LQE-4 test cancel'
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then should open page with 'Questionnaire Editor' title
When the user fills 'form1:table:globalFilter' field with 'LQE-4 test cancel'
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then should open page with 'Questionnaire Editor' title


