package wrapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class Wrapper {

	public RemoteWebDriver driver;
	
	
	public void invokeBrowser(String browser,String url) throws WebDriverException {		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new EdgeDriver();			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();;
			driver = new InternetExplorerDriver();			
		}else if(browser.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();;
			 driver = new OperaDriver();			
		} else {
			System.out.println("No Driver matches");
			//throw Exception();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	public WebElement locateSelector(String locType, String locValue) {
		System.out.println("driver---->"+driver);
		switch(locType.toLowerCase()) {
		case "id": return driver.findElement(By.id(locValue));
		case "link": return driver.findElement(By.linkText(locValue));
		case "class": return driver.findElement(By.className(locValue));
		case "partiallinktext": return driver.findElement(By.partialLinkText(locValue));
		case "name": return driver.findElement(By.name(locValue));
		case "cssselector": return driver.findElement(By.cssSelector(locValue));
		case "tagname": return driver.findElement(By.tagName(locValue));	
		}
		return null;
		
	}
	/**
	 * This method will find all matching element using any given Selector.
	 * 
	 * @param selType  		- The selector by which the element to be found
	 * @param selValue 		- The selector value by which the element to be found
	 * @author Anish 		- PreachTechs
	 * 
	 * @return A list of all WebElements, or an empty list if nothing matches.
	 */
	
	/*
	 * public List<WebElement> locateElements(String selType, String selValue){
	 * 
	 * List<WebElement> findElements = driver.findElements(By.tagName(selValue));
	 * 
	 * }
	 */
	
	
	
	/**
	 * This method will click the element and take snap
	 * 
	 * @param ele   	- The Webelement (button/link/element) to be clicked
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws StaleElementReferenceException
	 */
	public void click(WebElement ele) throws StaleElementReferenceException {
		ele.click();		
	}
	
	
	/**
	 * This method will enter the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @param data  	- The data to be sent to the webelement
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)	
	 */
	
	public void append(WebElement ele, String data) throws ElementNotInteractableException,IllegalArgumentException {
		ele.clear();
		ele.sendKeys(data);
		
	}
	/**
	 * This method will clear the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws InvalidElementStateException	(throws if not user-editable element)	 
	 */
	public void clear(WebElement ele) throws InvalidElementStateException {
		ele.clear();
	}
	
	
	/**
	 * This method will clear and type the value in the given text field 
	 * 
	 * @param ele   	- The Webelement (text field) in which the data to be entered
	 * @param data  	- The data to be sent to the webelement
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws ElementNotInteractable,IllegalArgumentException(throws if keysToSend is null)		 
	 */
	
	public void clearAndType(WebElement ele,String data) {
		ele.clear();
		ele.sendKeys(data);	
	}
	
	
	/**
	 * This method will get the visible text of the element
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTechs
	 */
	public String getElementText(WebElement ele) {
				String text = ele.getText();
				return text;
	}
	
	
	
	/**
	 * This method will get the Color values of the element
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTechs
	 * 
	 * @return The visible text of this element.
	 */
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("background");
		return cssValue;
	}
	
	
	
	/**
	 * This method will get the text of the element textbox
	 * 
	 * @param ele   	- The Webelement (button/link/element) in which text to be retrieved
	 * @author Anish 	- PreachTechs
	 * 
	 * @return The attribute/property's current value (or) null if the value is not set.
	 */
	public String getTypedText(WebElement ele) {
		String typetext = ele.getText();
		return typetext;
		
	}
	
	
	/**
	 * This method will select the drop down visible text
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param value 	- The value to be selected (visibletext) from the dropdown
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoSuchElementException
	 */
	
public void selectDropDownUsingText(WebElement ele, String value) throws NoSuchElementException {
	Select sel3 = new Select(ele);
	sel3.selectByVisibleText(value);
}

	



	/**
	 * This method will select the drop down using index
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param index 	- The index to be selected from the dropdown
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingIndex(WebElement ele, int index) throws NoSuchElementException {
		Select sel1 = new Select(ele);
		sel1.selectByIndex(index);
			
	}

	
	
	
	/**
	 * This method will select the drop down using value
	 * 
	 * @param ele   	- The Webelement (dropdown) to be selected
	 * @param value 	- The value to be selected (value) from the dropdown 
	 * @author Anish 	- 	PreachTechs
	 * 
	 * @throws NoSuchElementException
	 */
	public void selectDropDownUsingValue(WebElement ele, String value) throws NoSuchElementException {
		Select sel2 = new Select(ele);
		sel2.selectByValue(value);
		
	}
	
	
	
	
	
	
	
	
	/**
	 * This method will verify exact given text with actual text on the given element
	 * 
	 * @param ele   		- The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Anish 		- PreachTechs
	 * 
	 * @return true if the given object represents a String equivalent to this string, false otherwise
	 */
	public boolean verifyExactText(WebElement ele, String expectedText) {
		String text1 = ele.getText();
		boolean t = text1.contentEquals(expectedText);
		return t;
	}
	
	
	
	/**
	 * This method will verify given text contains actual text on the given element
	 * 
	 * @param ele  			- The Webelement in which the text to be need to be verified
	 * @param expectedText  - The expected text to be verified
	 * @author Anish 		- PreachTechs
	 * 
	 * @return true if this String represents the same sequence of characters as the specified string, false otherwise
	 */
//	public boolean verifyPartialText(WebElement ele, String expectedText) {}
		
		
	

	/**
	 * This method will verify exact given attribute's value with actual value on the given element
	 * 
	 * @param ele   	- The Webelement in which the attribute value to be need to be verified
	 * @param attribute - The attribute to be checked (like value, href etc)
	 * @param value  	- The value of the attribute
	 * @author Anish 	- PreachTechs
	 * 
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 */
//	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);
	
	/**
	 * This method will verify partial given attribute's value with actual value on the given element
	 * 
	 * @param ele   	- The Webelement in which the attribute value to be need to be verified
	 * @param attribute - The attribute to be checked (like value, href etc)
	 * @param value  	- The value of the attribute
	 * @author Anish 	- PreachTechs
	 * 
	 * @return true if this String represents the same sequence of characters as the specified value, false otherwise
	 * 
	 */
	
	
	
	//public boolean verifyPartialAttribute(WebElement ele, String attribute, String value);
	
	
	
	
	/**
	 * This method will verify if the element is visible in the DOM
	 * 
	 * @param ele   	- The Webelement to be checked
	 * @author Anish 	- PreachTechs
	 * 
	 * @return true if the element is displayed or false otherwise
	 */
	public boolean verifyDisplayed(WebElement ele) {
		boolean d = ele.isDisplayed();
		return d;
	}
	
	
	
	/**
	 * This method will verify if the input element is Enabled
	 * 
	 * @param ele   	- The WebElement (Radio button, Checkbox) to be verified
	 * @return true 	- if the element is enabled else false
	 * @author Anish 	- PreachTechs
	 * 
	 * @return True if the element is enabled, false otherwise.
	 */
	public boolean verifyEnabled(WebElement ele) {
		boolean e = ele.isEnabled();
		return e;
	}
	
	
	
	
	/**
	 * This method will verify if the element (Radio button, Checkbox) is selected
	 * 
	 * @param ele   	- The Webelement (Radio button, Checkbox) to be verified
	 * @author Anish 	- PreachTechs
	 * 
	 * @return True if the element is currently selected or checked, false otherwise.
	 */
	public boolean verifySelected(WebElement ele) {
		boolean s = ele.isSelected();
		return s;
	}

	
	
	
	/**
	 * This method will switch to the Alert
	 * 
	 * @author Anish - PreachTechs
	 * 
	 * @throws NoAlertPresentException
	 */
	public void switchToAlert() {
		
		driver.switchTo().alert();
	}

	
	
	
	
	/**
	 * This method will accept the alert opened
	 * 
	 * @author Anish - PreachTechs
	 * 
	 * @throws NoAlertPresentException
	 */
	public void acceptAlert() {
		
		//WebElement findElement = driver.findElement(null);
		driver.switchTo().alert().accept();
		
	}
	
	
	
	

	/**
	 * This method will dismiss the alert opened
	 * 
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoAlertPresentException
	 */
	public void dismissAlert() {
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * This method will return the text of the alert
	 * 
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoAlertPresentException
	 */
	public String getAlertText() {
	Alert alert = driver.switchTo().alert();
	String alertms = driver.switchTo().alert().getText();
	return alertms;
	}
	

	/**
	 * This method will enter the value in the alert
	 * 
	 * @author Anish 	- PreachTechs
	 * @param  data		- the data to be entered in alert
	 * 
	 * @throws NoAlertPresentException
	 */
	public void enterAlertText(String data) throws NoAlertPresentException {
		Alert al = driver.switchTo().alert();
		al.sendKeys(data);
	}

	/**
	 * This method will switch to the Window of interest
	 * 
	 * @param index The window index to be switched to. 0 -> first window 
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoSuchWindowException
	 */
	/*
	 * public void switchToWindow(int index) throws NoSuchWindowException {
	 * 
	 * Set<String> handles = driver.getWindowHandles(); List<String> ls = new
	 * ArrayList<String>(handles); driver.switchTo().window(ls.get(0)); }
	 */
	
	

	/**
	 * This method will switch to the specific frame using index
	 * 
	 * @param  index   	- The int (frame) to be switched
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(int index) throws NoSuchFrameException {
		driver.switchTo().frame(0);
	}
	
	
	

	/**
	 * This method will switch to the specific frame
	 * 
	 * @param  ele   	- The Webelement (frame) to be switched
	 * @author Anish 	- PreachTechs
	 * 
	 * @throws NoSuchFrameException, StaleElementReferenceException 
	 */
	public void switchToFrame(WebElement ele) throws NoSuchFrameException{
		
		driver.switchTo().frame(ele);
	}
	
	
	

	/**
	 * This method will switch to the specific frame using Id (or) Name
	 * 
	 * @param idOrName   - The String (frame) to be switched
	 * @author Anish 	 - PreachTechs
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(String idOrName) throws NoSuchFrameException{
		
		driver.switchTo().frame(idOrName);
	}
	
	
	

	/**
	 * This method will switch to the first frame on the page
	 * 
	 * @author Anish 	- PreachTechs
	 * 
	 * @return This driver focused on the top window/first frame.
	 */
	public void switchOutFrame() {
		driver.switchTo().frame(0);
	}

	/**
	 * This method will verify browser actual url with expected
	 * 
	 * @param url   	- The url to be checked
	 * @author Anish 	- PreachTechs
	 * 
	 * @return true if the given object represents a String equivalent to this url, 
	 * false otherwise
	 */
	public boolean verifyUrl(String url) {
		String currentUrl = driver.getCurrentUrl();
		boolean u = currentUrl.contentEquals(url);
		return u;
	}

	
	
	
	/**
	 * This method will verify browser actual title with expected
	 * 
	 * @param title 	- The expected title of the browser
	 * @author Anish 	- PreachTechs
	 * 
	 * @return true if the given object represents a String equivalent to this title, 
	 * false otherwise
	 */
	public boolean verifyTitle(String title) {
		
		String actualtitle = driver.getTitle();
		boolean b = actualtitle.contentEquals(title);
		return b;
	}

	
	
	
	/**
	 * This method will take snapshot of the browser
	 * 
	 * @author Anish 	- PreachTechs
	 * 
	 * @return Object in which is stored information about the screenshot.
	 * @throws IOException 
	 * @throws WebDriverException
	 */
	public File screenShot() throws IOException {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/1.png");
		FileUtils.copyFile(src, des);
		
		return des;
	}
	
	public void close() {
		driver.close();
	}

	
	public void quit() {
		driver.quit();
}

	
}
