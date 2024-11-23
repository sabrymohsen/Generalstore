package steps
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
import org.testng.Assert



import pages.HomePage
import pages.ShopPage
import pages.CartPage


HomePage homePage = new HomePage()
ShopPage shopPage = new ShopPage()
CartPage cartPage = new CartPage()

@Given("I launch the General Store app")
def launchApp() {
	Mobile.startApplication('C:\\Users\\User\\Downloads\\General-Store.apk', true)
}

@When("I select {string} from the country dropdown")
def selectCountry(String country) {
	Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.Spinner'), 0)
	
	Mobile.scrollToText('Egypt')
	
	Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.TextView - Egypt'), 0)
	
}

@When("I enter {string} as my name")
def enterName(String name) {
	Mobile.sendKeys(findTestObject('Object Repository/Generalstore/android.widget.EditText - Enter name here'), 'sabrymohsen')
}

@When("I select {string} as my gender")
def selectGender(String gender) {
    Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.RadioButton - Male'), 0)
}

@When("I click on the {string} button")
def clickLetsShop(String buttonText) {
   Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.Button - Lets  Shop'), 0)
}

@When("I add two products to the cart")
def addProductsToCart() {
   Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - Air Jordan 4 Retro'), 0)

   Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - Air Jordan 1 Mid SE'), 0)

   Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.TextView - ADD TO CART'), 0)

   Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.TextView - ADD TO CART (1)'), 0)
}

@Then("I should see both products in the cart")
def verifyProductsInCart() {
	Mobile.tap(findTestObject('Object Repository/Generalstore/android.widget.ImageButton'), 0)
    String product1 = Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - Air Jordan 4 Retro (1)'), 0)
    String product2 = Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - Air Jordan 1 Mid SE (1)'), 0)

    Assert.assertNotNull(product1, "First product not found in the cart.")
    Assert.assertNotNull(product2, "Second product not found in the cart.")
}

@Then("the total amount should equal the sum of the products")
def verifyTotalAmount() {
    	
    String price1String = Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - 160.97'), 0)
    String price2String = Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView - 120.0'), 0)
    String totalString = Mobile.getText(findTestObject('Object Repository/Generalstore/android.widget.TextView -  280.97'), 0)

   
    float price1 = price1String.replace('$', '').toFloat()
    float price2 = price2String.replace('$', '').toFloat()
    float total = totalString.replace('$', '').toFloat()

   
    float calculatedTotal = price1 + price2
    assert calculatedTotal == total : "Total amount mismatch! Calculated: ${calculatedTotal}, Displayed: ${total}"
}