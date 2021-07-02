package com.webTest.testCases;

import com.webTest.pageObjects.DeleteCustomer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteCustomerTest extends BaseClass {

   @Test
   public void DeleteCustomer() throws IOException, InterruptedException {
       LoginTest.loginTest();
       Thread.sleep(3000);
       DeleteCustomer delcust=new DeleteCustomer(driver);

       delcust.clickDelCustomer();

       logger.info("Clicked Delete Customer....");


       delcust.custId("1234");
       delcust.sumbit();
       Thread.sleep(3000);
       driver.switchTo().alert().accept();
       logger.info("clicked alert....");
       Thread.sleep(3000);
       if(isAlertPresent())
       {
           String res=driver.switchTo().alert().getText();
           driver.switchTo().alert().accept();
           if(res.equals("Customer does not exist!!")){
               logger.warn("Customer does not exist!!");
               captureScreen(driver,"DeleteCustomerTest");
               Assert.fail();
           }
           driver.switchTo().defaultContent();
           Assert.assertTrue(true);
           logger.info("Deleted Successfully");
       }
       else
       {
           logger.warn("Delete was not successful..");
           captureScreen(driver,"DeleteCustomerTest");
           Assert.fail();
       }

   }

}
