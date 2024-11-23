package pages

import mobile.MobileUtils
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert

class CartPage {

    MobileUtils mobileUtils = new MobileUtils()

    def verifyProductsInCart() {
        String product1 = mobileUtils.getText(findTestObject('Generalstore/android.widget.TextView - Air Jordan 4 Retro (1)'))
        String product2 = mobileUtils.getText(findTestObject('Generalstore/android.widget.TextView - Air Jordan 1 Mid SE (1)'))

        Assert.assertNotNull(product1, "First product not found in the cart.")
        Assert.assertNotNull(product2, "Second product not found in the cart.")
    }

    def verifyTotalAmount() {
        String price1 = mobileUtils.getText(findTestObject('Generalstore/android.widget.TextView - 160.97'))
        String price2 = mobileUtils.getText(findTestObject('Generalstore/android.widget.TextView - 120.0'))
        String total = mobileUtils.getText(findTestObject('Generalstore/android.widget.TextView -  280.97'))

        float calculatedTotal = Float.parseFloat(price1) + Float.parseFloat(price2)
        Assert.assertEquals(calculatedTotal, Float.parseFloat(total), "Total amount mismatch!")
    }
}
