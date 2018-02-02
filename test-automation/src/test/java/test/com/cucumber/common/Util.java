package test.com.cucumber.common;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Util extends PageObject{

    public static boolean isAttributePresent(WebElementFacade element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
                result = true;
            }
        } catch (Exception e) {}

        return result;
    }

    public static String getEnvironment(){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty("environment");
    }

    public static String getMessage(String key){
        String resourceName = "messages.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        String messageValue = "";
        try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            props.load(resourceStream);
            messageValue = props.get(key).toString();
        }
        catch (IOException e){}
        return messageValue;
    }

    public static String getProperty(String key){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        return variables.getProperty(key);
    }

    public Boolean isElementPresentInViewPort(WebElementFacade element){
        return (Boolean)evaluateJavascript("function isElementVisible(el) {\n" +
                "    var rect     = el.getBoundingClientRect(),\n" +
                "        vWidth   = window.innerWidth || doc.documentElement.clientWidth,\n" +
                "        vHeight  = window.innerHeight || doc.documentElement.clientHeight,\n" +
                "        efp      = function (x, y) { return document.elementFromPoint(x, y) };\n" +
                "\n" +
                "    // Return false if it's not in the viewport\n" +
                "    if (rect.right < 0 || rect.bottom < 0 \n" +
                "            || rect.left > vWidth || rect.top > vHeight)\n" +
                "        return false;\n" +
                "\n" +
                "    // Return true if any of its four corners are visible\n" +
                "    return (\n" +
                "          el.contains(efp(rect.left,  rect.top))\n" +
                "      ||  el.contains(efp(rect.right, rect.top))\n" +
                "      ||  el.contains(efp(rect.right, rect.bottom))\n" +
                "      ||  el.contains(efp(rect.left,  rect.bottom))\n" +
                "    );\n" +
                "};" +
                "return isElementVisible(arguments[0]);", element);
    }

}
