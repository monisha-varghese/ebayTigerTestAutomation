package test.com.cucumber;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
)
public class RunCukesTest {
    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("target/myreport.html");
    }

    @AfterClass
    public static void teardown() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", "Monisha Varghese");
        Reporter.setSystemInfo("os", "Windows 7");
        Reporter.setTestRunnerOutput("Automation Test Report");
    }

}
