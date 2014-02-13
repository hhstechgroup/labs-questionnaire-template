package com.engagepoint.acceptancetest;

import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import com.engagepoint.acceptancetest.base.steps.JbehaveBaseSteps;
import com.engagepoint.acceptancetest.base.steps.UseVariablesSteps;
import com.engagepoint.pageobjects.EditPage;
import com.engagepoint.pageobjects.HomePage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

    @Given("user is on Home page")
    public void userIsOnHomePage(){
        HomePage homePage = getPages().get(HomePage.class);
        homePage.open();
    }

    @When("opens all tree with className '$className'")
    @Alias("the user opens all tree with className '$className'")
    public void openAllTree(String className) {
        for (WebElement element : uIBootstrapBasePage.getDriver().findElements(By.className(className))) {
            element.click();
        }
    }

    @When("opens tree with className '$className'")
    @Alias("the user opens tree with className '$className'")
    public void openTree(String className) {
        for (WebElement element : uIBootstrapBasePage.getDriver().findElements(By.className(className))) {
            element.click();
            break;
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
    public void waitForTimeout(int timeout) {
        uIBootstrapBasePage.waitFor(timeout).seconds();
    }

    @Then("button with $title is visible")
    public void buttonWithTitleIsVisible(String title) {
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button[@title='" + title + "']"));
    }

    @Then("element with $text is visible")
    public void elementWithTextIsVisible(String text) {
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
    }

    @Then("the user clicks button with title '$Edit'")
    public void clickedButtonEdit(String id){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button [@title ='"+ id +"']")).click();
    }
    @When("the user fills '$id' field with '$value'")
    public void writeTextInField (String id,String value){
        uIBootstrapBasePage.enter(value).intoField(findVisibleElementAndGetSelector(id));
    }

    @Then("the user clicks  button with id '$id'")
    public void clickButton(String id){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button [@id ='"+ id +"']")).click();
    }

    @Then("the user clicks element with id '$id'")
    public void clickElement(String id){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//span [@id ='"+ id +"']")).click();
    }

    @When("the user clicks button with id '$id'")
    public void clickButtonWithId(String id){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button [@id ='"+ id +"']")).click();
    }
    @When("the user clicks button with value '$id'")
    public void clickButtonWithValue(String value){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button [@value ='" + value + "']")).click();
    }

    @When("the user clicks button with title '$id'")
    public void clickButtonWithTitle(String title){
        uIBootstrapBasePage.getDriver().findElement(By.xpath("//button [@title ='"+ title +"']")).click();
    }

    @Then("Edit page is shown")
    public void editPageIsShown(){
        pages().isCurrentPageAt(EditPage.class);
    }

    @Then("clicks button with className '$className'")
    public void openMenuButton(String className) {
        List<WebElement> list = uIBootstrapBasePage.getDriver().findElements(By.className(className));
        for (int i = 0; i < list.size() ; i++) {
            if (i == 2){
                list.get(i).click();
            }

        }
    }

//    @Then("the user is brought to the '$url')
//    public void thenTheUserIsBroughtToThePageWithQuestionnaireEditorTitleLQE3() {
//        uIBootstrapBasePage.getDriver().getPageSource() ==
//    }

}