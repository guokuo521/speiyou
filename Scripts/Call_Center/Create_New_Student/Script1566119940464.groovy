import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import javax.lang.model.element.VariableElement as VariableElement
import com.kms.katalon.core.testcase.Variable as Variable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.waitForPageLoad(2000, FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Login/input__username'), '3018')

WebUI.setEncryptedText(findTestObject('CallCenter/CreateNewStudent/Page_Login/input_password'), '4nvbrPglk7k=')

WebUI.click(findTestObject('CallCenter/Page_Login/btn_login'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_custmor_dropdown'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/btn_signup'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/button_addNewStudent'))

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/input_studentName'), stuname)

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/input_birthday'), birthday)

userSex()

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_city_list_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_beiijing'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_city_list_2'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_beijingArea'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_gtade_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_xiaoxue'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_gtade_2'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/li_grade3'))

WebUI.setText(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/input_phone'), '136' + CustomKeywords.'utils.seleniumUtil.get8RandomNum'())

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_mother_1'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/select_mother_2'))

WebUI.click(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/button_safe'))

WebUI.verifyElementPresent(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/text_create_success'), 2000)

WebUI.verifyCheckpoint(findCheckpoint('Checkpoints/Checkpoint'), false)

WebUI.switchToDefaultContent()

WebUI.closeBrowser()

def userSex() {
    if (String.valueOf(sex) == '女') {
        WebUI.clickImage(findTestObject('CallCenter/CreateNewStudent/Page_Create_New_Student/raido_girl'))
    }
}

