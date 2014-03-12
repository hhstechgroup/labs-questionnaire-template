package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.SectionBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* Created by yurii.kukharskyi on 1/28/14.
*/
public class SectionBeanTest {
    MockTemplate mock = new MockTemplate(QuestionType.CHECKBOX);

    @Test
    public void testCloneSectionBean() throws Exception {
        //Assert.assertTrue(mock.creatorSections().equals(mock.creatorSections().clone()));

    }

}
