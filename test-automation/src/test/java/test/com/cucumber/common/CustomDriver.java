package test.com.cucumber.common;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import java.util.logging.Level;


public class CustomDriver implements DriverSource{

    @Override
    public WebDriver newDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        return new ChromeDriver(capabilities);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
