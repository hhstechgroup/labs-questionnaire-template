package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public class TemplateBeanMock {
    static List<TemplateBean> list=new ArrayList<TemplateBean>();
    static TemplateBean defaultVal;

    /// **************** Create New Examples in static initialisation *******************
    static
    {
        defaultVal = builder("Template a",SectionBeanMock.getList());
        list.add(defaultVal);
        //list.add(builder("Template b", null));

    }
    /// ***********************************************************************

    static public List<TemplateBean> getList(){
        return list;
    }
    static public TemplateBean getSingle(){return  defaultVal;}

    static private TemplateBean builder(String name,  List<SectionBean> sections){
        TemplateBean template = new TemplateBean();
        template.setTemplateName(name);
        template.setSectionsList(sections);

        return template;
    }
}
