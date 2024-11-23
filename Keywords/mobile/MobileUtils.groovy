package mobile

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject

class MobileUtils {

    @Keyword
    def void launchApplication(String appPath) {
        try {
            Mobile.startApplication(appPath, true)
            KeywordUtil.logInfo("Successfully launched application from path: ${appPath}")
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to launch application. Error: ${e.message}")
        }
    }

    @Keyword
    def void tapElement(TestObject to) {
        try {
            Mobile.tap(to, 0)
            KeywordUtil.logInfo("Tapped on element: ${to.getObjectId()}")
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to tap on element: ${to.getObjectId()}. Error: ${e.message}")
        }
    }

    @Keyword
    def void sendKeys(TestObject to, String text) {
        try {
            Mobile.setText(to, text, 0)
            KeywordUtil.logInfo("Entered text: '${text}' into element: ${to.getObjectId()}")
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to send text to element: ${to.getObjectId()}. Error: ${e.message}")
        }
    }

    @Keyword
    def void scrollToText(String text) {
        try {
            Mobile.scrollToText(text)
            KeywordUtil.logInfo("Scrolled to text: '${text}'")
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to scroll to text: '${text}'. Error: ${e.message}")
        }
    }

    @Keyword
    def String getText(TestObject to) {
        try {
            String text = Mobile.getText(to, 0)
            KeywordUtil.logInfo("Retrieved text: '${text}' from element: ${to.getObjectId()}")
            return text
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to get text from element: ${to.getObjectId()}. Error: ${e.message}")
            return null
        }
    }

    @Keyword
    def float parsePrice(String priceString) {
        try {
            
            return priceString.replace('$', '').toFloat()
        } catch (Exception e) {
            KeywordUtil.markFailed("Failed to parse price from string: '${priceString}'. Error: ${e.message}")
            return 0.0
        }
    }
}