package com.engagepoint.bean;

public interface BasicOperationWithBean {
    void deleteFromInnerList(Object o);
    void addToInnerList(Object o);
    @Override
    String toString();
}
