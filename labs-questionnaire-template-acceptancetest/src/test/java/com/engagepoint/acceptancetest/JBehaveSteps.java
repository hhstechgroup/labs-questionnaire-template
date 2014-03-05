package com.engagepoint.acceptancetest;

import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import com.engagepoint.acceptancetest.base.steps.JbehaveBaseSteps;
import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Special steps for this project.
 */
public class JBehaveSteps {

    private static final String TABLE_TAG = "table";
    private String testName;
    private String questionType;
    private String questionText;
    private String helpText;

    @Steps
    private JbehaveBaseSteps jbehaveBase;

    private transient UIBootstrapBasePage uIBootstrapBasePage;

    private WebElement getTableElement(String id) {
        By tableBy = jbehaveBase.findVisibleElementAndGetSelector(id);
        WebElement tableElement = uIBootstrapBasePage.getDriver().findElement(tableBy);
        if (!tableElement.getTagName().contentEquals(TABLE_TAG))
            tableElement = tableElement.findElement(By.tagName(TABLE_TAG));
        return tableElement;
    }

    @When("in table '$tableId' user chooses to display '$number' elements per page")
    public void whenInTableChoosesToDisplayNumberElementsPerPageXPath2(String tableId, String number) {
        /*not worked: WebElement rppSelect = getTableElement(tableId).findElement(By.cssSelector(".ui-paginator-rpp-options"));*/
        WebElement rppSelect = getTableElement(tableId).findElement(By.xpath("//select[contains(@class, 'ui-paginator-rpp-options')]"));
        uIBootstrapBasePage.selectFromDropdown(rppSelect, number);
    }

    @When("in tree '$treeId' user chooses node with '$text'")
    public void whenInTreeChoosesNodeWithText(String treeId, String nodeText) {
        WebElement tableElement = getTableElement(treeId);
        WebElement row = tableElement.findElement(By.xpath(".//*[contains(@class,'ui-treetable-selectable-node')]//*[contains(text(),'"+nodeText+"')]"));
        row.click();
    }

    @When("in table '$tableId' user presses '$buttonText' in row with '$text'")
    public void whenInTableChoosesRowWithText(String tableId, String buttonText, String rowText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = tableElement.findElement(By.xpath("//*[.//td[contains(text(),'"+rowText+"')]]//*[@title='"+buttonText+"']")); //TODO: bind path to table
        row.click();
    }

    @When("in table '$tableId' user presses '$buttonText' in row with <testName>")
    public void whenInTableChoosesRowWithTestName(String tableId, String buttonText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = tableElement.findElement(By.xpath("//*[.//td[contains(text(),'"+testName+"')]]//*[@title='"+buttonText+"']")); //TODO: bind path to table
        row.click();
    }

    @When("in tree '$treeId' user opens node with '$text'")
    public void whenInTreeOpensNodeWithText(String treeId, String nodeText) {
        WebElement tableElement = getTableElement(treeId);
        try {
            WebElement row = tableElement.findElement(By.xpath(".//td[.//*[contains(text(),'"+nodeText+"')]]/span[contains(@class,'ui-treetable-toggler') and contains(@class,'ui-icon-triangle-1-e')]"));
            row.click();
        }
        catch (Exception e) {

        }

    }

    @When("choose '$type' from drop-down")
    public void whenChooseTypeFromDropDown(String type) {
        Actions builder = new Actions(uIBootstrapBasePage.getDriver());

        WebElement elementOfDropDown = uIBootstrapBasePage.getDriver().findElement(By.xpath("//li[@data-label='" + type + "']"));
        while (!elementOfDropDown.isDisplayed()) {
            builder.sendKeys(Keys.ARROW_DOWN).perform();
            elementOfDropDown = uIBootstrapBasePage.getDriver().findElement(By.xpath("//li[@data-label='"+type+"']"));
        }
        elementOfDropDown.click();
    }

    @Then("in table '$tableId' there is a row with '$text'")
    public void thenInTableThereIsARowWithText(String tableId, String rowText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = tableElement.findElement(By.xpath("//*[.//td[contains(text(),'"+rowText+"')]]")); //TODO: bind path to table
        assertTrue(row.isDisplayed());
    }

    @Then("in table '$tableId' there is not a row with '$text'")
    public void thenInTableThereIsNotARowWithText(String tableId, String rowText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = null;
        try {
            row = tableElement.findElement(By.xpath("//*[.//td[contains(text(),'"+rowText+"')]]")); //TODO: bind path to table
        }
        catch(Exception e) {
        }
        assertNull(row);
    }

    @Then("the checkbox id/name/className '$id' is checked")
    public void thenTheCheckBoxIsOn(String id) {
        try {
            WebElement checkedCheckBox = uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[@id='"+id+"']//*[contains(@class,'ui-icon-check')]"));
            assertTrue(true);
        }
        catch(Exception e) {
            assertTrue(false);
        }

    }

    @Then("the checkbox id/name/className '$id' is unchecked")
    public void thenTheCheckBoxIsOff(String id) {
        try {
            WebElement checkedCheckBox = uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[@id='"+id+"']//*[contains(@class,'ui-icon-check')]"));
            assertTrue(false);
        }
        catch(Exception e) {
            assertTrue(true);
        }
    }

    @When("the checkbox id/name/className '$id' is checked uncheck it")
    public void whenTheCheckBoxIsOnMakeItUnchecked(String id) {
        try {
            WebElement checkedCheckBox = uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[@id='"+id+"']//*[contains(@class,'ui-icon-check')]"));
            checkedCheckBox.click();
        }
        catch(Exception e) {
        }
    }

    @When("the checkbox id/name/className '$id' is unchecked check it")
    public void whenTheCheckBoxIsOffMakeItChecked(String id) {
        try {
            WebElement checkedCheckBox = uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[@id='"+id+"']//*[contains(@class,'ui-icon-check')]"));
        }
        catch(Exception e) {
            WebElement uncheckedCheckBox = uIBootstrapBasePage.getDriver().findElement(By.xpath("//*[@id='"+id+"']"));
            uncheckedCheckBox.click();
        }
    }

    @Given("name of current test")
    public void givenNameOfCurrentTest(@Named("testName") String testName) {
        this.testName = testName;
    }

    @Given("question type")
    public void givenQuestionType(@Named("questionType") String questionType) {
        this.questionType = questionType;
    }

    @Given("questionText and helpText")
    public void givenQuestionTextAndHelpText(@Named("questionText") String questionText, @Named("helpText") String helpText) {
        this.questionText = questionText;
        this.helpText = helpText;
    }

    @When("the user fills '$id' field with testName")
    public void fillFieldWithTestName(String id) {
        uIBootstrapBasePage.enter(testName).intoField(jbehaveBase.findVisibleElementAndGetSelector(id));
    }

    @When("choose question type from drop-down")
    public void whenChooseQuestionTypeFromDropDown() {
        Actions builder = new Actions(uIBootstrapBasePage.getDriver());

        WebElement elementOfDropDown = uIBootstrapBasePage.getDriver().findElement(By.xpath("//li[@data-label='" + questionType + "']"));
        while (!elementOfDropDown.isDisplayed()) {
            builder.sendKeys(Keys.ARROW_DOWN).perform();
            elementOfDropDown = uIBootstrapBasePage.getDriver().findElement(By.xpath("//li[@data-label='"+questionType+"']"));
        }
        elementOfDropDown.click();
    }

    @When("the user fills '$id' field with question text")
    public void fillFieldWithQuestionText(String id) {
        uIBootstrapBasePage.enter(questionText).intoField(jbehaveBase.findVisibleElementAndGetSelector(id));
    }

    @When("the user fills '$id' field with help text")
    public void fillFieldWithHelpText(String id) {
        uIBootstrapBasePage.enter(helpText).intoField(jbehaveBase.findVisibleElementAndGetSelector(id));
    }

    @Then("element '$id' has attribute value of question text")
    public void verifyThatElementHasValueOfQuestionText(String id) {
        assertThat(uIBootstrapBasePage.element(jbehaveBase.findVisibleElementAndGetSelector(id)).getValue(), is(equalTo(questionText)));
    }

    @Then("element '$id' has attribute value of help text")
    public void verifyThatElementHasValueOfHelpText(String id) {
        assertThat(uIBootstrapBasePage.element(jbehaveBase.findVisibleElementAndGetSelector(id)).getValue(), is(equalTo(helpText)));
    }
}
