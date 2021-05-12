package com.test.seleniumlearning;

import org.testng.annotations.Test;

import wrapper.Wrapper;

public class TrainingCreateContact extends Wrapper{
	
	@Test
	public void CreateContact() {//en
	invokeBrowser("Chrome","http://iarchtaps.com:8080/opentaps/control/main/");  //Test
	append(locateSelector("id","username"),"DemoSalesManager");
	append(locateSelector("id","password"),"crmsfa");
	click(locateSelector("class","decorativeSubmit"));
	click(locateSelector("link","CRM/SFA"));
	click(locateSelector("link","Create Contact"));
	append(locateSelector("id","firstNameField"),"Vand"); //Test
	append(locateSelector("id","lastNameField"),"Yad");
	append(locateSelector("id","createContactForm_generalProfTitle"),"Health Care");
	append(locateSelector("id","createContactForm_departmentName"),"QA");
	selectDropDownUsingText(locateSelector("id","createContactForm_generalStateProvinceGeoId"),"Colorado");
	locateSelector("class","smallSubmit").submit();
		
}

}
