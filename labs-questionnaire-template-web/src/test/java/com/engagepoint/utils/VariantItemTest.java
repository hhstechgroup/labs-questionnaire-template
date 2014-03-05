package com.engagepoint.utils;

import com.engagepoint.model.question.utils.VariantItem;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anton.kovunov on 3/5/14.
 */
public class VariantItemTest {
    @Test
    public void testCloneVariantItem() throws CloneNotSupportedException {
        VariantItem var1 = new VariantItem("blahblah");
        Assert.assertTrue(var1.equals(var1.clone()));
    }
    @Test
    public void testEqualsVariantItem(){
        VariantItem var1 = new VariantItem("blahblah");
        VariantItem var2 = new VariantItem("blahblah");
        Assert.assertTrue(var1.equals(var2));
    }
}
