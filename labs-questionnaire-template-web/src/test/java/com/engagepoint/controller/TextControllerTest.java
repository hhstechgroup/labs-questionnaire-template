package com.engagepoint.controller;

import com.engagepoint.controller.question.TextQuestionController;
import org.junit.Test;

/**
 * Created by anton.kovunov on 3/19/14.
 */
public class TextControllerTest {
    @Test
    public void testTextController(){
        TextQuestionController controller = new TextQuestionController();
        controller.postConstruct();
    }
}
