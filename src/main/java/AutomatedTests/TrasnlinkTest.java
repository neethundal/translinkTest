package AutomatedTests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.MyFavsPage;
import PageObjects.NextBusResultPage;

/**
 * @author navneet.hundal
 *
 */

public class TrasnlinkTest {

    private WebDriver driver;
    
    public LandingPage landingPage;
    public NextBusResultPage nextBusResultPage;
    public MyFavsPage myFavsPage;

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        landingPage = new LandingPage(driver, "https://www.translink.ca/", "Landing Page");
    }
   
    @AfterMethod
	public void tearDown() {			 
		 driver.quit();
	}
    
    @Test
    public void translinkTest() throws InterruptedException
    {
    	synchronized(driver) {
    		
    	landingPage.get();
    	driver.wait(3000);
    	nextBusResultPage = landingPage.selectNextBus("99");
    	driver.wait(1000);
    	nextBusResultPage.addFav("Translink Auto Homework");
    	driver.wait(1000);
    	myFavsPage = nextBusResultPage.openMyFavs();
    	driver.wait(1000);
    	myFavsPage.select("Translink Auto Homework");
    	driver.wait(2000);
    	Assert.assertTrue(nextBusResultPage.getBusName().equals("99 Commercial-Broadway / UBC (B-Line)"));
    	nextBusResultPage.selectRoute("To Comm'l-Bdway Stn / Boundary B-Line");
    	driver.wait(2000);
    	nextBusResultPage.selectStop("UBC Exchange Bay 7");
    	driver.wait(2000);
    	nextBusResultPage.verifyStop("Stop # 61935");
    	}	
    }	
    }


