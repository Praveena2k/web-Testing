package com.webTest.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webTest.pageObjects.LoginPage;
import com.webTest.utilities.XLUtils;

public class LoginDDT extends BaseClass
{

    @Test(dataProvider="LoginData")
    public void loginDDT(String user,String pwd) throws InterruptedException
    {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(user);
        logger.info("user name provided");
        lp.setPassword(pwd);
        logger.info("password provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        if(isAlertPresent())
        {
            driver.switchTo().alert().accept();//close alert
            driver.switchTo().defaultContent();
            Assert.fail();
            logger.warn("Login failed");
        }
        else
        {
            Assert.assertTrue(true);
            logger.info("Login passed");
            lp.clickLogout();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();//close logout alert
            driver.switchTo().defaultContent();

        }


    }





    @DataProvider(name="LoginData")
    String [][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"/src/test/java/com/webTest/testData/LoginData.xlsx";

        int rownum=XLUtils.getRowCount(path, "Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
            }

        }
        return logindata;
    }

}
