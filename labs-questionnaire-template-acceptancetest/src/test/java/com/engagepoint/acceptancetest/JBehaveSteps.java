package com.engagepoint.acceptancetest;

import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import com.engagepoint.acceptancetest.base.steps.JbehaveBaseSteps;
import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

/**
 * Special steps for this project.
 */
public class JBehaveSteps {

    private static final String TABLE_TAG = "table";

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

    @When("in tree '$treeId' user opens node with '$text'")
    public void whenInTreeOpensNodeWithText(String treeId, String nodeText) {
        WebElement tableElement = getTableElement(treeId);
        WebElement row = tableElement.findElement(By.xpath(".//td[.//*[contains(text(),'"+nodeText+"')]]/span[contains(@class,'ui-treetable-toggler')]"));
        row.click();
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
}
