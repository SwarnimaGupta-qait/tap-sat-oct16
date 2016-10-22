package com.qait.demo.keywords;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

public class ProductDetailsActions extends GetPage {

	WebDriver driver;
	private EventFiringWebDriver e_driver;
	String parenthandle="";
	
	public ProductDetailsActions(WebDriver driver) {
		super(driver, "HomePage");
		this.driver = driver;

	}

	public void AddTheProductToCart() {
		// TODO Auto-generated method stub
		parenthandle = driver.getWindowHandle();
		 for(String winHandle : driver.getWindowHandles()){
		        driver.switchTo().window(winHandle);
		    }
		  
		   executeJavascript("document.getElementsByClassName('col-xs-6 btn btn-xl btn-theme-secondary rippleWhite buyLink')[0].click();");
	}

}
