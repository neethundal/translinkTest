package PageObjects;

import java.util.Objects;

/**
 * @author navneet.hundal
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyFavsPage extends BasePage{

    Element elements = new Element();
    
	MyFavsPage(WebDriver driver, String locator, String pageName) {
		super(driver, locator, pageName);
		// TODO Auto-generated constructor stub
	}


    
    class Element {
    	
   	 private final By MY_FAVOURITES = By.xpath("//*[@id=\"content\"]/div[2]/section[3]/div[1]/ul");
	 WebElement myFavourites() { return driver.findElement(MY_FAVOURITES); }
    }



	public void select(String favname) {

   	 WebElement fav = this.elements.myFavourites().findElement(By.linkText(favname));
   	 Assert.assertTrue(!Objects.isNull(fav));
   	 fav.click();
	}
}
