package com.test.seleniumlearning;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import wrapper.Wrapper;

public class TrainingTest1 extends Wrapper{
	
	@Test
	public void LauchBrowser() {
		invokeBrowser("Chrome","http://iarchtaps.com:8080/opentaps/control/main/"); //Test comment
		WebElement ele = locateSelector("id","username");
		append(ele,"DemoSalesManager");
		//locateSelector("id","password");
		append(locateSelector("id","password"),"crmsfa");
		click(locateSelector("class","decorativeSubmit"));
		click(locateSelector("link","CRM/SFA"));
				
	}

}
