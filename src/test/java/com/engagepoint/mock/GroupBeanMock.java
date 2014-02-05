package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupBeanMock {
    static List<GroupBean> list = new ArrayList<GroupBean>();
    static Map<String, List<GroupBean>> map = new HashMap<String, List<GroupBean>>();
    static GroupBean defaultVal;

    /// **************** Create New Examples in static initialization *******************
    static
    {
        defaultVal=builder("Group name 2", QuestionBeanMock.getList());
        //defaultVal=builder("Group name 2", null);
        list.add(defaultVal);
        //list.add(builder("Group name 1", null));

        List<GroupBean> list2 = new ArrayList<GroupBean>();
        list2.add(builder("Group name 3", null));

        map.put("notNull", list);
    }
    /// ***********************************************************************

    static public List<GroupBean> getList(){
        return list;
    }
    static public List<GroupBean> getList(String key){
        return map.get(key);
    }
    static public GroupBean getSingle(){return  defaultVal;}

    static private GroupBean builder(String name, List<QuestionBean> questions){
        GroupBean group = new GroupBean();
        group.setGroupName(name);
        group.setQuestionsList(questions);

        return group;
    }
}
