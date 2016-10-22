package com.qait.demo.keywords;



import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;

public class ResultsPageActions extends GetPage {
	
	WebDriver driver;

    public ResultsPageActions(WebDriver driver) {
        super(driver, "ResultsPage");
        this.driver = driver;
    }

	
	public void verifySearchResults(String resultText) {
		isElementDisplayed("area_searchResult");
		Assert.assertTrue(element("txt_resultCount",resultText).isDisplayed(), "Result count section is not present");
		logMessage("Search Results successfully displayed");
	}
	
	
	public void getResponseCode(String url){
		logMessage("Status Code for the URL '"+url+"' :- "+ apiTester.getStatusCodeOfTheService(url));
	}

	public void getHeaders(String url){
		Map<String, List<String>> map = apiTester.getAllHeaderFields(url);
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			logMessage("Map value:- "+it.next());
		}
	}


	public void clickFirstProduct() {
		// TODO Auto-generated method stub
		List<WebElement> li=elements("resultList");
		li.get(0).click();
	}


	public void verifyResults(String yamlValue) {
		// TODO Auto-generated method stub
		String str=element("searchKeyword").getText();
		Assert.assertTrue(str.contains(yamlValue), "[ASSERT FAILED]: Results are not appropriate.");
	}
	
	
    
    
}
