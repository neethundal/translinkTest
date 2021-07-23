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

public class TrasnlinkTest {

    private WebDriver driver;
    Element elements = new Element();

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
   
    @AfterMethod
	public void tearDown() {			 
		 driver.quit();
	}

    class Element {
    	 private final By NEXT_BUS_TAB = By.xpath("//*[@id=\"next-bus\"]");
    	 private final By BUS_ROUTE_SEARCH_TXT = By.xpath("//*[@id=\"NextBusSearchTerm\"]");
    	 private final By FIND_NEXT_BUS_BTN = By.xpath("//*[@id=\"next-bus_tab\"]/section/div/div[2]/button"); 
    	 private final By ADD_FAV_BTN = By.xpath("//*[@id=\"content\"]/div[4]/section[3]/div[2]/div/button");
    	 private final By ADD_FAVOURITE_TXT = By.xpath("//*[@id=\"add-to-favourites_dialog\"]/form/section/label/textarea");
    	 private final By ADD_TO_FAV_BTN = By.xpath("//*[@id=\"add-to-favourites_dialog\"]/form/section/div/button");
    	 private final By MY_FAV_BTN = By.xpath("//*[@id=\"content\"]/div[4]/section[3]/div[2]/div/a[3]");
    	 private final By MY_FAVOURITES = By.xpath("//*[@id=\"content\"]/div[2]/section[3]/div[1]/ul");
    	 private final By FAV_STOP = By.xpath("//*[@id=\"MainContent_PanelStops\"]/div[1]");
    	 private final By ROUTES = By.xpath("//*[@id=\"MainContent_PanelStops\"]");
    	 private final By END_STOPS = By.xpath("//*[@id=\"MainContent_PanelStops\"]/div[3]/section[3]");
    	 private final By STOP = By.xpath("//*[@id=\"schedule\"]/div/div[1]/div[3]");
    	 
    	 WebElement nextBusBtn() { return driver.findElement(NEXT_BUS_TAB); }
    	 WebElement busRouteSearchTxt() { return driver.findElement(BUS_ROUTE_SEARCH_TXT);}
    	 WebElement findNextBusBtn() { return driver.findElement(FIND_NEXT_BUS_BTN);}
    	 WebElement addFavBtn()  { return driver.findElement(ADD_FAV_BTN); }
    	 WebElement addFavouriteTxt()  { return driver.findElement(ADD_FAVOURITE_TXT); }
    	 WebElement addToFavBtn() { return driver.findElement(ADD_TO_FAV_BTN); }
    	 WebElement myFavBtn() { return driver.findElement(MY_FAV_BTN); }
    	 WebElement myFavourites() { return driver.findElement(MY_FAVOURITES); }
     	 WebElement favStop() { return driver.findElement(FAV_STOP); }
    	 WebElement routes() { return driver.findElement(ROUTES); }
    	 WebElement endStops() { return driver.findElement(END_STOPS); }
    	 WebElement stop() { return driver.findElement(STOP); }
    }
    
    @Test
    public void test() throws InterruptedException
    {
    	synchronized(driver) {
    	 driver.get("https://new.translink.ca/");
    	 driver.wait(3000);
    	 this.elements.nextBusBtn().click();
    	 this.elements.busRouteSearchTxt().sendKeys("99");
    	 
    	 this.elements.findNextBusBtn().click();
    	 driver.wait(1000);
    	 this.elements.addFavBtn().click();
    	 driver.wait(1000);
    	 this.elements.addFavouriteTxt().clear();
    	 this.elements.addFavouriteTxt().sendKeys("Translink Auto Homework");
    	 this.elements.addToFavBtn().click();
    	 driver.wait(1000);
    	 this.elements.myFavBtn().click();
    	 driver.wait(1000);
    	 WebElement fav = this.elements.myFavourites().findElement(By.linkText("Translink Auto Homework"));
    	 Assert.assertTrue(!Objects.isNull(fav));
    	 fav.click();
    	 driver.wait(1000);
    	 driver = driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/section[3]/iframe")));
    	 driver.wait(1000);
    	 boolean isCommBLineDisplayed = this.elements.favStop().getText().equals("99 Commercial-Broadway / UBC (B-Line)");
    	 Assert.assertTrue(isCommBLineDisplayed);
    	 this.elements.routes().findElement(By.linkText("To Comm'l-Bdway Stn / Boundary B-Line")).click();
    	 driver.wait(1000);
    	 this.elements.endStops().findElement(By.linkText("UBC Exchange Bay 7")).click();
    	 driver.wait(1000);
    	 Assert.assertTrue(this.elements.stop().getText().equals("Stop # 61935"));
    	}
    }

}
