package com.engagepoint.mock.impl.bean;

import com.engagepoint.mock.MockBean;

import java.util.ArrayList;
import java.util.List;

public class MockBeanContainer {
    List<MockBean> list = new ArrayList<MockBean>();

    public MockBeanContainer(){
        list.add(new AllNullMockBean());
        list.add(new NotNullBeans());
    }

    public void add(MockBean bean){
        list.add(bean);
    }

    public List<MockBean> getList(){
        return list;
    }

}
