package com.test.seleniumlearning;

import org.testng.annotations.Test;

import wrapper.Wrapper;

public class TrainingDeactivateContact extends Wrapper {
	
	@Test
	public void DeactivateContact() {
	invokeBrowser("Chrome","http://iarchtaps.com:8080/opentaps/control/main/");
	append(locateSelector("id","username"),"DemoSalesManager");
	append(locateSelector("id","password"),"crmsfa");
	click(locateSelector("class","decorativeSubmit"));
	click(locateSelector("link","CRM/SFA"));
	click(locateSelector("link","Create Contact"));
	append(locateSelector("id","firstNameField"),"Vand");
	append(locateSelector("id","lastNameField"),"Yad");
	append(locateSelector("id","createContactForm_generalProfTitle"),"Health Care");
	append(locateSelector("id","createContactForm_departmentName"),"QA");
	selectDropDownUsingText(locateSelector("id","createContactForm_generalStateProvinceGeoId"),"Colorado");
	locateSelector("class","smallSubmit").submit();
	click(locateSelector("link","Edit"));
	append(locateSelector("id","updateContactForm_description"),"Hi");
	locateSelector("class","smallSubmit").submit();	
	click(locateSelector("link","Deactivate Contact"));
	acceptAlert();
	
}

}
