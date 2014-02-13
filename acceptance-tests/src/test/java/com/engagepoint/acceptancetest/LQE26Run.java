package com.engagepoint.acceptancetest;

import net.thucydides.core.Thucydides;
import net.thucydides.core.reports.html.HtmlAggregateStoryReporter;
import net.thucydides.jbehave.ThucydidesJUnitStories;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/13/14
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class LQE26Run {
    private static String testsFolder;

    public static void main(String[] args) throws Throwable {
        if(args.length == 1) {
            testsFolder = args[0];
            new RunableIT().run();
        } else {
            testsFolder = "**";
            new RunableIT().run();
        }
        File sourceDirectory = new File("target/site/thucydides/");
        HtmlAggregateStoryReporter reporter = new HtmlAggregateStoryReporter(Thucydides.getDefaultProjectKey());
        reporter.setOutputDirectory(sourceDirectory);
        reporter.generateReportsForTestResultsFrom(sourceDirectory);
        System.exit(0);
    }

    public static class RunableIT extends ThucydidesJUnitStories {

        public RunableIT() {
            configuredEmbedder().embedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
        }

        @Override
        public List<String> storyPaths() {
            return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()),
                    asList("**/" + testsFolder + "/**/LQE26.story"), asList(""));
        }
    }
}
