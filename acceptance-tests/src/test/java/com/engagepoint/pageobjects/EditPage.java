package com.engagepoint.pageobjects;

import com.engagepoint.acceptancetest.base.pages.UIBootstrapBasePage;
import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/12/14
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
@At("#HOST/questionnaire-template-web-1.0-SNAPSHOT/pages/questForm*")
@DefaultUrl("/questionnaire-template-web-1.0-SNAPSHOT/pages/questForm.xhtml?item={1}")
public class EditPage extends UIBootstrapBasePage {

    public EditPage(WebDriver driver) {
        super(driver);
    }
}
