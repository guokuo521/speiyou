package utils

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.*;

public class seleniumUtil {

	WebDriver driver;

	@Keyword
	def get8RandomNum(){

		def random
		StringBuffer sb = new StringBuffer()
		for (i in 1..8) {
			random=(int)(Math.random()*8+1)
			sb.append(random)
		}
		return sb
	}

	@Keyword
	def clickElementBTN(TestObject to){
		try {
			clickTheClickable(to,System.currentTimeMillis(),2000);
		} catch (StaleElementReferenceException e) {
			KeywordUtil.markFailed( "The element you clicked:[" + to + "] is no longer exist!")
		} catch(Exception e){
			KeywordUtil.markFailed "Failed to click element [" + to + "]"
		}
		KeywordUtil.markPassed "click" + to.findXpathValue("")
	}

	def clickTheClickable(TestObject to,long startTime,int timeOut){
		WebUI wb = new WebUI()
		try {
			wb.findWebElement(to).click()
		} catch (Exception e) {

			if(System.currentTimeMillis()-startTime >timeOut){
				KeywordUtil.logInfo to + "is unclickable"
			}
			else{
				KeywordUtil.logInfo to + " is unclickable, try again"
			}
		}
	}
	@Keyword
	def clickUsingJS(TestObject to) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, 30)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (StaleElementReferenceException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}


	/**
	 * 验证接口返回值
	 */
	@Keyword
	def verifyStatusCode(TestObject request, int expectedStatusCode) {
		if (request instanceof RequestObject) {
			RequestObject requestObject = (RequestObject) request
			ResponseObject response = WS.sendRequest(requestObject)
			if (response.getStatusCode() == expectedStatusCode) {
				KeywordUtil.markPassed("Response status codes match")
			} else {
				KeywordUtil.markFailed("Response status code not match. Expected: " +
						expectedStatusCode + " - Actual: " + response.getStatusCode() )
			}
		} else {
			KeywordUtil.markFailed(request.getObjectId() + " is not a RequestObject")
		}
	}

	/**
	 * 获取页面标题
	 */
	@Keyword
	def getTitle(){
		return WebUI.getWindowTitle();
	}

	/**
	 * 获取元素文本
	 */
	@Keyword
	def getText(TestObject to){
		return driver.findElement(to).getText().trim()
	}

	/**
	 * 模拟键盘操作的,比如Ctrl+A,Ctrl+C等 参数详解：<br>
	 * 1、WebElement element - 要被操作的元素 <br>
	 * 2、Keys key- 键盘上的功能键 比如ctrl ,alt等 <br>
	 * 3、String keyword - 键盘上的字母
	 */
	@Keyword
	def pressKeysOnKeyboard(WebElement element,Keys key,String keyword){
		element.sendKeys(Keys.chord(key, keyword))
	}
}
