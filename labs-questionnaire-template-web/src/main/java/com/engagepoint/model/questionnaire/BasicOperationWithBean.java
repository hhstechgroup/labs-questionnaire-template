package com.engagepoint.model.questionnaire;

/**
 * Basic operation with beans
 * Have methods need fot beans high level
 * (beans who contains lis of include beans)
 */
public interface BasicOperationWithBean {
    void deleteFromInnerList(Object o);
    void addToInnerList(Object o);
}
