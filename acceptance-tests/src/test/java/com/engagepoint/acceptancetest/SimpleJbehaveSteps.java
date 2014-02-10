package com.engagepoint.acceptancetest;

import com.engagepoint.acceptancetest.base.filedownload.FileDownloader;
import com.engagepoint.acceptancetest.base.filedownload.utils.RequestMethod;
import com.engagepoint.acceptancetest.base.filedownload.utils.RequestParameters;
import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import com.engagepoint.acceptancetest.base.steps.JbehaveBaseSteps;
import com.engagepoint.acceptancetest.base.steps.UseVariablesSteps;
import net.thucydides.core.Thucydides;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleJbehaveSteps extends ScenarioSteps {


    private static final String XPATH_SELECTOR_SUFFIX = "')]";
    private UIBootstrapBasePage uIBootstrapBasePage;

    private static final Logger LOGGER = LoggerFactory.getLogger(UseVariablesSteps.class);

    @Steps
    private JbehaveBaseSteps jbehaveBase;

    public SimpleJbehaveSteps(Pages pages) {
        super(pages);
        uIBootstrapBasePage = pages().get(UIBootstrapBasePage.class);
    }

    @When("opens all tree with className '$className'")
    @Alias("the user opens all tree with className '$className'")
    public void openAllTree(String className) {
        for (WebElement element : uIBootstrapBasePage.getDriver().findElements(By.className(className))) {
            element.click();
        }
    }

    @When("clicks on all elements with className '$className' with text '$text'")
    @Alias("the user clicks on all elements with className '$className' with text '$text'")
    public void clickByText(String className, String text) {
        for (WebElement webElement : uIBootstrapBasePage.getDriver().findElements(By.className(className))) {
            if (webElement.getText().equalsIgnoreCase(text)) {
                webElement.click();
            }
        }
    }

    @When("clicks on first element with className '$className' with text '$text'")
    @Alias("the user clicks on first element with className '$className' with text '$text'")
    public void clickOnFirstTreeElementByText(String className, String text) {
        for (WebElement webElement : uIBootstrapBasePage.getDriver().findElements(By.className(className))) {
            if (webElement.getText().equalsIgnoreCase(text)) {
                webElement.click();
                break;
            }
        }
    }

    @When("the user fills '$id' field with '$contextPath' using baseUrl")
    @Alias("'$id' field with '$contextPath' using baseUrl")
    public void fillField(String id, String contextPath) {
        String baseUrl = pages().getConfiguration().getBaseUrl();
        int lastSlash = baseUrl.lastIndexOf('/');
        String url = baseUrl.substring(0, lastSlash - 3);
        uIBootstrapBasePage.enter(url + contextPath).intoField(findVisibleElementAndGetSelector(id));
    }

    @Then("wait for element '$id' is not visible")
    public void waitForElementWithIdIsNotPresent(String id) {
        uIBootstrapBasePage.waitForRenderedElementsToDisappear(findVisibleElementAndGetSelector(id));
    }

    @Then("wait for element '$id' is visible")
    public void waitForElementWithIdIsPresent(String id) {
        uIBootstrapBasePage.waitForRenderedElementsToBePresent(findVisibleElementAndGetSelector(id));
    }

    private By findVisibleElementAndGetSelector(String id) {
        By[] selectors = {By.id(id), By.xpath("//*[contains(@id, '" + id + XPATH_SELECTOR_SUFFIX), By.name(id), By.className(id)};
        for (By selector : selectors) {
            if (isElementDisplayed(selector)) {
                return selector;
            }
        }
        return selectors[0];
    }

    private boolean isElementDisplayed(By selector) {
        try {
            return uIBootstrapBasePage.element(selector).isCurrentlyVisible();
        } catch (Exception e) {
        }
        return false;
    }

    @When("clicks on all elements with xpathOrCss '$xpathOrCss'")
    @Alias("the user clicks on all elements with xpathOrCss '$xpathOrCss'")
    public void openAllElementsBySelector(String xpathOrCss) {
        for (WebElement element : uIBootstrapBasePage.getDriver().findElements(By.cssSelector(xpathOrCss))) {
            element.click();
        }
    }

    @Then("wait for '$timeout' sec")
    public void waitForTimeout(int timeout){
        uIBootstrapBasePage.waitFor(timeout).seconds();
    }
	
}