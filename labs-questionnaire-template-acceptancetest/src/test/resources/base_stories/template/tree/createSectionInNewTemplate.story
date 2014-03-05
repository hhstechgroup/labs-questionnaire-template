GivenStories: base_stories/template/createAndStartEditTemplateForStory.story

Scenario: Create section in new template

When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait for element 'formTemplate:form:btnDisplayAddGroup' is visible

