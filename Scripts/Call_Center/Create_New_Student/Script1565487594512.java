import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

WebDriver driver

WebUI.openBrowser('')

WebUI.navigateToUrl('http://call-center-beta.speiyou.net/login')

WebUI.setText(findTestObject('Object Repository/CallCenter/CreateNewStudent/Page_Login/input__username'), '3018')

WebUI.setEncryptedText(findTestObject('Object Repository/CallCenter/CreateNewStudent/Page_Login/input_password'), '4nvbrPglk7k=')

WebUI.click(findTestObject('Object Repository/CallCenter/CreateNewStudent/Page_Login/btn_login'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/list_customer'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/btn_signup'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/button_addNewStudent'))

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/input_studentName'), '随机输入')

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_city_list_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_beiijing'))

WebElement element = driver.findElement(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_beiijing'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_city_list_2'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_beijingArea'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_gtade_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_xiaoxue'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_gtade_2'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_grade3'))

String phoneNum = "136" + CustomKeywords.'utils.seleniumUtil.get8RandomNum'()

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/input_phone'), phoneNum)

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_mother_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_mama'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/button_safe'))

WebUI.verifyElementText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/text_result'), '新增失败:修改联系人或邮寄地址信息失败，请选择编辑学员维护信息！')

