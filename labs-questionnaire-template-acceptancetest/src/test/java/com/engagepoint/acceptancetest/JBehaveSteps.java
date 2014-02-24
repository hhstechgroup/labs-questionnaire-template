package com.engagepoint.acceptancetest;

import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import com.engagepoint.acceptancetest.base.steps.JbehaveBaseSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    @When("in tree '$tableId' user chooses node with '$text'")
     public void whenInTreeChoosesNodeWithText(String tableId, String rowText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = tableElement.findElement(By.xpath(".//*[contains(@class,'ui-treetable-selectable-node')]//*[contains(text(),'"+rowText+"')]"));
        row.click();
    }

    @When("in table '$tableId' user presses '$buttonText' in row with '$text'")
    public void whenInTreeChoosesRowWithText(String tableId, String buttonText, String rowText) {
        WebElement tableElement = getTableElement(tableId);
        WebElement row = tableElement.findElement(By.xpath("//*[.//td[contains(text(),'"+rowText+"')]]//*[@title='"+buttonText+"']"));
        row.click();
    }
}
