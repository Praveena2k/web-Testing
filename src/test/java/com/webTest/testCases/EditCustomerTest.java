package com.webTest.testCases;

import com.webTest.pageObjects.EditCustomer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditCustomerTest extends BaseClass  {

    @Test
    public void EditCustomer() throws IOException, InterruptedException {

        LoginTest.loginTest();
        Thread.sleep(3000);
        EditCustomer editCust = new EditCustomer(driver);

        editCust.clickEditCustomer();

        logger.info("Clicked Edit Customer....");

        editCust.custId("87602");
        editCust.sumbit();
        Thread.sleep(3000);

        if(isAlertPresent())
        {
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();
            logger.info("CustId doesn't exists....");
            captureScreen(driver,"EditCustomerTest");
            Assert.fail();
        }

        editCust.custaddress("INDIA");
        editCust.custcity("HYD");
        editCust.custstate("AP");
        editCust.custpinno("5000074");
        editCust.custtelephoneno("987890091");
        Thread.sleep(3000);
        editCust.edit();
        logger.info("Edited and Clicked Submit....");
    }


    }
