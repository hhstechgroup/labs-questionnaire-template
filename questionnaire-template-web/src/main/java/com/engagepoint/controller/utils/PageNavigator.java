package com.engagepoint.controller.utils;


public class PageNavigator {

    public static String goToIndexPage() {
        return "/index?faces-redirect=true&includeViewParams=true";
    }

    public static String goToQuestionEditPage() {
        return "/pages/questionEdit?faces-redirect=true&includeViewParams=true";
    }


}
