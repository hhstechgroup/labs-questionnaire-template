package com.engagepoint.container;

import com.engagepoint.model.question.rules.RenderedRule;
import com.engagepoint.model.question.rules.RuleType;
import com.engagepoint.model.question.rules.RulesContainer;
import org.junit.Assert;
import org.junit.Test;

import static com.engagepoint.model.question.rules.RuleType.RENDERED;

/**
 * Created by anton.kovunov on 3/19/14.
 */
public class RulesContainerTest {

    @Test
    public void testContainerRule(){
        RulesContainer container = new RulesContainer();

        RenderedRule rule = new RenderedRule();
        Assert.assertTrue(rule.equals(container.createRule("1. " + RENDERED.description())));
        Assert.assertNull(container.createRule(null));




    }

}
