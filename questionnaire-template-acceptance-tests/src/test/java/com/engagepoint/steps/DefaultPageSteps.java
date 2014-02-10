package com.engagepoint.steps;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class DefaultPageSteps extends Steps {
    private WebDriver webDriver;

    @Given("a browser")
    public void init() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("I put $url")
    public void putUrl(String url) {
        webDriver.get(url);
    }

    @Then("the page title should be $pageTitle")
    public void checkPageTitle(String pageTitle) {
        assertEquals("Incorrect page title", pageTitle, webDriver.getTitle());
    }

}
