import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class AddNewProductSteps {
	@Given("user on home page")
	def userOnHomePage() {
		Mobile.startApplication('C:\\app-debug.apk', true)
	}

	@When("user click plus button")
	def clickPlusButton() {
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.widget.Button'), 10)
		
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.widget.Button'), 10)
	}

	@And("user fill the product name")
	def fillProductName() {
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.widget.EditText - Name'), 10)
		Mobile.setText(findTestObject('Object Repository/AddNewProduct/android.widget.EditText - Name (1)'), 'daging', 10)
		
	}
	
	@And("user dont fill the product name")
	def blankProductName() {
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.widget.EditText - Name'), 10)

	}

	@And("user fill the product quantity")
	def fillProductQuantity() {
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.widget.EditText - 1, Quantity'), 10)
		Mobile.setText(findTestObject('Object Repository/AddNewProduct/android.widget.EditText - 1, Quantity (1)'), '30', 10)
		
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.widget.EditText - 1, Quantity'), 10)
		Mobile.setText(findTestObject('Object Repository/AddNewProductInvalid/android.widget.EditText - 1, Quantity (1)'), '12',
			10)
	}

	@And("user choose the product categories")
	def chooseCategories() {
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.widget.Button (1)'), 10)
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.view.View'), 10)
		
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.widget.Button (1)'), 10)
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.view.View'), 10)
	}

	@And ("user click the add button")
	def clickAddButton() {
		Mobile.tap(findTestObject('Object Repository/AddNewProduct/android.widget.Button (2)'), 10)
		
		Mobile.tap(findTestObject('Object Repository/AddNewProductInvalid/android.widget.Button (2)'), 10)
		
	}

	@Then("item will be on the home page")
	def newItemIsOnHomePage(){
		Mobile.closeApplication()

	}
	
	@Then("user see Must be between 1 and 50 characters message")
	def seeMessage() {
		Mobile.closeApplication()
		
	}
}