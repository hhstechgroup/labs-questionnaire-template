package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public interface MockBean {
    TemplateBean getTemplate();
    SectionBean getSection();
    GroupBean getGroup();
    QuestionBean getQuestion();
    String description();
}
