package com.webTest.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.webTest.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

    static ReadConfig readconfig=new ReadConfig();

    public static String baseURL=readconfig.getApplicationURL();
    public static String username=readconfig.getUsername();
    public static String password=readconfig.getPassword();
    public static WebDriver driver;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) //Selecting browser to open the url
    {
        logger = Logger.getLogger("Demo_ebanking");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
            driver=new ChromeDriver();
        }
        else if(br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() //Quit the browser
    {
        driver.quit();
    }

    public static void captureScreen(WebDriver driver, String tname) throws IOException    //Take Screenshots
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomestring() //Produce Random String
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static boolean isAlertPresent() //user defined method created to check alert is presetn or not
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e)
        {
            return false;
        }

    }

}
