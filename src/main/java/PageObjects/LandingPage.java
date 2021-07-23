package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author navneet.hundal
 *
 */

public class LandingPage extends BasePage {
	
	Element elements = new Element();
	
	public LandingPage(WebDriver driver, String locator, String pageName) {
	    	super(driver, locator, pageName);
	    	}
	
	    public NextBusResultPage selectNextBus(String bus) throws InterruptedException
	    {
	    	 this.elements.nextBusBtn().click();
	    	 this.elements.busRouteSearchTxt().sendKeys(bus);
	    	 this.elements.findNextBusBtn().click();
	    	 return new NextBusResultPage(this.driver, this.driver.getCurrentUrl(), this.driver.getTitle());
	    }
	    
	    class Element {
	    	
	    	 private final By NEXT_BUS_TAB = By.xpath("//*[@id=\"next-bus\"]");
	    	 private final By BUS_ROUTE_SEARCH_TXT = By.xpath("//*[@id=\"NextBusSearchTerm\"]");
	    	 private final By FIND_NEXT_BUS_BTN = By.xpath("//*[@id=\"next-bus_tab\"]/section/div/div[2]/button"); 
	    	 
	    	 WebElement nextBusBtn() { return driver.findElement(NEXT_BUS_TAB); }
	    	 WebElement busRouteSearchTxt() { return driver.findElement(BUS_ROUTE_SEARCH_TXT);}
	    	 WebElement findNextBusBtn() { return driver.findElement(FIND_NEXT_BUS_BTN);}
	    	 
	    	
	    }

}
