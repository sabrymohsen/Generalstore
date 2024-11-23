import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.cucumber.keyword.internal.CucumberGlueGenerator

class CucumberTestListener {
    /**
     * Executes before every test case starts.
     * @param testCaseContext related information of the executed test case.
     */
    @BeforeTestCase
    def beforeTestCase(TestCaseContext testCaseContext) {
        CucumberGlueGenerator.addDefaultPackages()
    }
}
