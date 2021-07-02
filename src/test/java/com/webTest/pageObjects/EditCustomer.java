package com.webTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {

    WebDriver ldriver;

    public EditCustomer(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using ="Edit Customer")
    @CacheLookup
    WebElement lnkEditCustomer;

    @FindBy(how = How.NAME, using = "cusid")
    @CacheLookup
    WebElement txtCustomerId;

    @CacheLookup
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement btnSubmit;

    @CacheLookup
    @FindBy(how = How.NAME, using = "addr")
    WebElement txtaddress;

    @CacheLookup
    @FindBy(how = How.NAME, using = "city")
    WebElement txtcity;

    @CacheLookup
    @FindBy(how = How.NAME, using = "state")
    WebElement txtstate;

    @CacheLookup
    @FindBy(how = How.NAME, using = "pinno")
    WebElement txtpinno;

    @CacheLookup
    @FindBy(how = How.NAME, using = "telephoneno")
    WebElement txttelephoneno;

    @CacheLookup
    @FindBy(how = How.NAME, using = "sub")
    WebElement Submit;

    public void clickEditCustomer() {
        lnkEditCustomer.click();

    }

    public void custId(String cid) {
        txtCustomerId.sendKeys(cid);

    }

    public void sumbit() {
        btnSubmit.click();
    }
    public void custaddress(String caddress) {
        txtaddress.sendKeys(caddress);
    }

    public void custcity(String ccity) {
        txtcity.sendKeys(ccity);
    }

    public void custstate(String cstate) {
        txtstate.sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        txtpinno.sendKeys(String.valueOf(cpinno));
    }

    public void custtelephoneno(String ctelephoneno) {
        txttelephoneno.sendKeys(ctelephoneno);
    }

    public void edit() {
        Submit.click();
    }
}
