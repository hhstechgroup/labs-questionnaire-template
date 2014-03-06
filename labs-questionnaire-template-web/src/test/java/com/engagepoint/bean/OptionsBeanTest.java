//package com.engagepoint.bean;
//
//import com.engagepoint.model.question.options.OptionsQuestionBean;
//import com.engagepoint.model.question.QuestionBean;
//import com.engagepoint.model.question.utils.VariantItem;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by anton.kovunov on 3/5/14.
// */
//public class OptionsBeanTest {
//    @Test
//    public void testOptionsBeanClone() throws CloneNotSupportedException {
//        OptionsQuestionBean testBean = new OptionsQuestionBean();
//        VariantItem var1 = new VariantItem("blahblah");
//        VariantItem var2 = new VariantItem("blahblahn");
//        VariantItem var3 = new VariantItem("defiler");
//        List<VariantItem> allVariants = new ArrayList<VariantItem>();
//        allVariants.add(var1);
//        allVariants.add(var2);
//        allVariants.add(var3);
//        List<VariantItem> chosenVariants = new ArrayList<VariantItem>();
//        chosenVariants.add(var1);
//        testBean.setDefaultOptions(chosenVariants);
//        testBean.setOptions(allVariants);
//        testBean.setDefaultOption(var2);
//        Assert.assertTrue(testBean.equals(testBean.clone()));
//
//    }
//}
