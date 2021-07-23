package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * @author navneet.hundal
 *
 */
import org.openqa.selenium.support.ui.LoadableComponent;

public class BasePage extends LoadableComponent<BasePage>{
	
	WebDriver driver;
	String locator;
	String pageName;
	
	BasePage(WebDriver driver, String locator, String pageName) {
		super();
		this.driver = driver;
		this.locator = locator;
		this.pageName = pageName;
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(locator);
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		//page not loaded
		if (this.driver.getCurrentUrl().equalsIgnoreCase("data:,")) 			
			throw new Error(this.pageName + " is not loaded!");
		
		if (this.driver.getCurrentUrl().equalsIgnoreCase("about:blank")) 			
			throw new Error(this.pageName + " is not loaded!");

	}

}
