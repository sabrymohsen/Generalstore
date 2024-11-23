package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import mobile.MobileUtils

class ShopPage {

    MobileUtils mobileUtils = new MobileUtils()

    def addProductsToCart() {
        mobileUtils.tapElement(findTestObject('Generalstore/android.widget.TextView - ADD TO CART'))
        mobileUtils.tapElement(findTestObject('Generalstore/android.widget.TextView - ADD TO CART (1)'))
    }

    def navigateToCart() {
        mobileUtils.tapElement(findTestObject('Generalstore/android.widget.ImageButton'))
    }
}
