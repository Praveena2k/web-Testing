package com.webTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

    WebDriver ldriver;

    public DeleteCustomer(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using ="Delete Customer")
    @CacheLookup
    WebElement lnkDeleteCustomer;

    @FindBy(how = How.NAME, using = "cusid")
    @CacheLookup
    WebElement txtCustomerId;

    @CacheLookup
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement btnSubmit;


    public void clickDelCustomer() {
        lnkDeleteCustomer.click();

    }

    public void custId(String cid) {
        txtCustomerId.sendKeys(cid);

    }

    public void sumbit() {
        btnSubmit.click();
    }

}
