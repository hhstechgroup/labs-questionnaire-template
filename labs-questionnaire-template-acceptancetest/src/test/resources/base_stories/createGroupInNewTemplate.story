GivenStories: base_stories/createSectionInNewTemplate.story
Scenario:
Create group in new section of new template
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddGroup'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_1'
Then wait for element 'formTemplate:form:btnDisplayAddQuestion' is visible