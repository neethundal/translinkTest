package PageObjects;

import org.openqa.selenium.By;

/**
 * @author navneet.hundal
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.MyFavsPage.Element;

public class NextBusResultPage extends BasePage{

    Element elements = new Element();
    
	NextBusResultPage(WebDriver driver, String locator, String pageName) {
		super(driver, locator, pageName);
		// TODO Auto-generated constructor stub
	}
	
    public void addFav(String favname) throws InterruptedException
    {
    	 this.elements.addFavBtn().click();
    	 driver.wait(1000);
    	 this.elements.addFavouriteTxt().clear();
    	 this.elements.addFavouriteTxt().sendKeys(favname);
    	 this.elements.addToFavBtn().click();
    	 driver.wait(1000);
    }
    
    class Element {
    	
   	 private final By ADD_FAV_BTN = By.xpath("//*[@id=\"content\"]/div[4]/section[3]/div[2]/div/button");
   	 private final By ADD_FAVOURITE_TXT = By.xpath("//*[@id=\"add-to-favourites_dialog\"]/form/section/label/textarea");
   	 private final By ADD_TO_FAV_BTN = By.xpath("//*[@id=\"add-to-favourites_dialog\"]/form/section/div/button");
	 private final By MY_FAV_BTN = By.xpath("//*[@id=\"content\"]/div[4]/section[3]/div[2]/div/a[3]");
	 private final By BUS_NAME = By.xpath("//*[@id=\"MainContent_PanelStops\"]/div[1]");
	 private final By ROUTES = By.xpath("//*[@id=\"MainContent_PanelStops\"]");
	 private final By STOPS = By.xpath("//*[@id=\"MainContent_PanelStops\"]/div[3]/section[3]");private final By STOP = By.xpath("//*[@id=\"schedule\"]/div/div[1]/div[3]");
	 
   	 
   	 WebElement addFavBtn()  { return driver.findElement(ADD_FAV_BTN); }
   	 WebElement addFavouriteTxt()  { return driver.findElement(ADD_FAVOURITE_TXT); }
   	 WebElement addToFavBtn() { return driver.findElement(ADD_TO_FAV_BTN); }
	 WebElement myFavBtn() { return driver.findElement(MY_FAV_BTN); }
	 WebElement busName() { return driver.findElement(BUS_NAME); }
	 WebElement routes() { return driver.findElement(ROUTES); }
	 WebElement stops() { return driver.findElement(STOPS); }
	 WebElement stop() { return driver.findElement(STOP); }
   }

	public MyFavsPage openMyFavs() {
		// TODO Auto-generated method stub
		this.elements.myFavBtn().click();;
		return new MyFavsPage(this.driver, this.driver.getCurrentUrl(), this.driver.getTitle());
	}
	
	public String getBusName() {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/section[3]/iframe")));
		String tmp = this.elements.busName().getText();
		driver.switchTo().defaultContent();
		return tmp;
	}
	
	public void selectRoute(String route) {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/section[3]/iframe")));
		this.elements.routes().findElement(By.linkText(route)).click();
		driver.switchTo().defaultContent();

	}
	
	public void selectStop(String stop) {
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/section[3]/iframe")));
		this.elements.stops().findElement(By.linkText("UBC Exchange Bay 7")).click();
		driver.switchTo().defaultContent();
	}

    public void verifyStop(String stopTxt) throws InterruptedException
    {
    	driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/section[3]/iframe")));
    	 Assert.assertTrue(this.elements.stop().getText().equals(stopTxt));
 		driver.switchTo().defaultContent();
    }
	

}
