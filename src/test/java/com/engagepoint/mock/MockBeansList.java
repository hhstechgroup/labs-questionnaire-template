package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

import java.util.List;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public interface MockBeansList {
    List<TemplateBean> getTemplatesList();
    List<SectionBean>  getSectionsList();
    List<GroupBean>    getGroupsList();
    List<QuestionBean> getQuestionsList();
}
