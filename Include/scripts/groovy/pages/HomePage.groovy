package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import mobile.MobileUtils

class HomePage {

    MobileUtils mobileUtils = new MobileUtils()

    def launchApp(String appPath) {
        mobileUtils.launchApplication(appPath)
    }

    def selectCountry(String country) {
        mobileUtils.tapElement(findTestObject('Generalstore/android.widget.Spinner'))
        mobileUtils.scrollToText(country)
        mobileUtils.tapElement(findTestObject("Generalstore/android.widget.TextView - ${country}"))
    }

    def enterName(String name) {
        mobileUtils.enterText(findTestObject('Generalstore/android.widget.EditText - Enter name here'), name)
    }

    def selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            mobileUtils.tapElement(findTestObject('Generalstore/android.widget.RadioButton - Male'))
        } else {
            mobileUtils.tapElement(findTestObject('Generalstore/android.widget.RadioButton - Female'))
        }
    }

    def clickLetsShop() {
        mobileUtils.tapElement(findTestObject('Generalstore/android.widget.Button - Lets  Shop'))
    }
}
