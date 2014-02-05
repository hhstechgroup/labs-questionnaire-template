package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;
import com.engagepoint.bean.SectionBean;

import java.util.ArrayList;
import java.util.List;


public class SectionBeanMock {
    static List<SectionBean> list = new ArrayList<SectionBean>();
    static SectionBean defaultVal;

    /// **************** Create New Examples in static initialisation *******************
    static
    {
        defaultVal=builder(1,GroupBeanMock.getList());
        list.add(defaultVal);
        //list.add(builder(2, null));
    }
    /// ***********************************************************************

    static public List<SectionBean> getList(){
        return list;
    }
    static public SectionBean getSingle(){return  defaultVal;}

    static private SectionBean builder(Integer pageNumber,  List<GroupBean> groups){
        SectionBean section = new SectionBean();
        section.setPageNumber(pageNumber);
        section.setGroupsList(groups);

        return section;
    }
}
