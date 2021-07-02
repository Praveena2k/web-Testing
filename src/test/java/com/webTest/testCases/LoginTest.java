package com.webTest.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.webTest.pageObjects.LoginPage;


public class LoginTest extends BaseClass
{

    @Test
    public static void loginTest() throws IOException
    {

        logger.info("URL is opened");

        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered username");

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.fail();
            logger.info("Login test failed");
        }

    }
}
