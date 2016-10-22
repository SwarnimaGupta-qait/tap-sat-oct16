/**
* This is a sample test recorded in selenium ide and exported to eclipse

* Step 1 : Open snapdeal.com
* Step 2 : Search A product - Mobile
* Step 3 : Select First Product
* Step 4 : Add the product to cart
* Step 5 : Verify the product has been added to cart
* 
* Task : You have to fix this test and run it.
*/



package com.qait.demo.tests;

import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import junit.framework.Assert;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLevel1_SnapDeal_Selenium_Imported_From_IDE_Broken_Needs_To_Be_Fixed {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  WebDriverWait wait;
  String parenthandle="";
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.snapdeal.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    this.wait = new WebDriverWait(driver,10);
    parenthandle = driver.getWindowHandle();
  }

  @Test
  public void Test01_testECommerceSite() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("inputValEnter")).click();
    driver.findElement(By.id("inputValEnter")).clear();
    driver.findElement(By.id("inputValEnter")).sendKeys("mobile");
    driver.findElement(By.xpath("//button[@onclick=\"submitSearchForm('go_header');\"]")).click();
    driver.findElement(By.xpath("(//img[contains(@class,'product-image')])[1]")).click();
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }
  
    ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('col-xs-6 btn btn-xl btn-theme-secondary rippleWhite buyLink')[0].click();");
   
  }

  @Test
  public void Test02_productAddedToCart(){
	  String str=driver.findElement(By.cssSelector("span.mess-text")).getText();
	  boolean response=isElementPresent(By.cssSelector("span.mess-text"));
	  Assert.assertTrue("[ASSERT FAILED]: Product not added.", response==true && str.contains("added to your cart"));
  }
  
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
