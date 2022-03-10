package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	// here we never create static method
	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {  //create a constructor
		this.driver = driver;
	}
	
	public By getBy(String locatorType,String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css selector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagName":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}
		return locator;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public String doGetAttribute(By locator ,String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public void doClick(String locatorType,String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}
	
	public void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	public void doSendKeys(String locatorType,String locatorValue,String value) {
		getElement(getBy(locatorType,locatorValue)).sendKeys(value);
	}
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public  List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public int getElementCount(By locator) {
		return getElements(locator).size();
	}
	public void printElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
		
	/**
	 * This method will return the of element's text
	 */
	}
	public  List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String>eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
			eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	/**
	 * This method will return the of element's attribute value
	 * @param locator
	 * @param attrName
	 * @return
	 */
	public  List<String> getElementsAttributeList(By locator,String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String>eleAttrList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attrVal = e.getAttribute(attrName);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}
	public void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());

		for (WebElement e : langList) {
			String text = e.getText();
			if (text.contains(linkText)) {
				e.click();
				break;}
		}
	}
	/******************************************************DropDownUtils*************************************/
	public void doSelectDropDownValueByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public void doSelectDropDownValueByVisibleText(By locator,String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}
	public void doSelectDropDownValueByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	public List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String>optionsTextlist = new ArrayList<String>();
		System.out.println(optionsList.size());//get the size of dropdown menu
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsTextlist.add(text);
		}
		return optionsTextlist;
	}
	public void selectValueFromDropDown(By locator,String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;}
		}
	}
/* ********************************************************Actions class******************************************** */
	public void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	/**
	 * Clicks in the middle of the given element.
	 * Equivalent to: Actions.moveToElement(onElement).click()
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	/*********************************wait utils**********************************/
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it
	 * @param locator
	 * @param timeOut
	 */
	public void clickWhenReady(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/*********************************util for wait for url**********************************/
	
	public  String waitForUrlContains(String urlFraction,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	public  String waitForUrlToBe(String url,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		return null;
	}
	/*********************************util for wait for alert**********************************/
	public  Alert waitForAlerts(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public  String getAlertText(int timeOut) {
		return waitForAlerts(timeOut).getText();
	}
	public  void acceptAlert(int timeOut) {
		waitForAlerts(timeOut).accept();
	}
	public  void dismissAlert(int timeOut) {
		waitForAlerts(timeOut).dismiss();
	}
	/*********************************util for wait for Frame**********************************/
	public  WebDriver waitForFrameByIndex(int timeout,int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	public  WebDriver waitForFrameByLocator(int timeout,By framelocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framelocator));
	}
	public  WebDriver waitForFrameByWebElement(int timeout,WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	/*********************************util for wait for elements**********************************/
	/**
	 * 
	 * 
	 * An expectation for checking that all elements present on the web page that match the locator are visible. 
	 * Visibility means that the elements are not only displayed but also have a height and width that is greater than 0
	 * 
	 * @param Locator
	 * @param timeout
	 * @return
	 */
	public List<WebElement> waitForElementsVisible(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	}
	
	public List<WebElement> waitForElementsVisible(By Locator, int timeout,int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Locator));
	}
	
	/**
	 * An expectation for checking that there is at least one element present on a web page
	 * @param Locator
	 * @param timeout
	 * @return
	 */
	public List<WebElement> waitForElementsPresence(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Locator));
	}
	
	
	/*********************************util for wait for elements**********************************/
	public  WebElement waitForElementPresenceWithFluentWait(By Locator, int timeOut, int poliingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(poliingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(Locator +"is not found within the given time...");
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	   
	}

	public  WebElement waitForElementPresenceWithWait(By Locator, int timeOut, int poliingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(poliingTime))
		.ignoring(NoSuchElementException.class)
		.ignoring(StaleElementReferenceException.class)
		.withMessage(Locator +"is not found within the given time...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
    }
	
}
