package com.engagepoint.mock.impl.list;

import com.engagepoint.mock.MockBeansList;
import com.engagepoint.mock.impl.bean.NotNullBeans;

import java.util.ArrayList;
import java.util.List;

public class MockBeansListContainer {
    List<MockBeansList> list = new ArrayList<MockBeansList>();

    public MockBeansListContainer(){
        //list.add(new AllNullMockBeansList());
        //list.add(new OneNullOneRealBeansList());
        list.add(new AllFilledBeansList());
    }
    public void add(MockBeansList bean){
        list.add(bean);
    }

    public List<MockBeansList> getList(){
        return list;
    }

}
