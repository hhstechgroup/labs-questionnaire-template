package com.engagepoint.pageobjects;

import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;


/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/12/14
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
@At("#HOST/questionnaire-template-web-1.0-SNAPSHOT/")
public class HomePage extends PageObject {
    /*from example
    @CacheLookup
    @FindBy(name="adFilter.searchTerm")
    WebElement searchTerm;

    @CacheLookup
    @FindBy(css=".keywords button")
    WebElement search;*/

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*from example
    public void chooseRegion(String region) {
        findBy("#location-select .arrow").then().click();
        waitFor(500).milliseconds();
        findBy("//ul[@class='dropdown-menu']//a[.='" + region + "']").then().click();
    }

    public void chooseCategoryFromDropdown(String category) {
        getDriver().navigate().refresh();
        findBy("#category-select").then(".arrow").then().click();
        findBy("//span[@id='category-select']//a[contains(.,'" + category + "')]").then()
                .click();
    }

    public void enterKeywords(String keywords) {
        element(searchTerm).type(keywords);
    }

    public void performSearch() {
        element(search).click();
    } */
}