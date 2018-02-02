package test.com.cucumber.pages;

import io.appium.java_client.pagefactory.WithTimeout;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;


@DefaultUrl("https://www.ebay.com.au/")
@NamedUrls(
        {
                @NamedUrl(name="ebayOnlineURL", url = "https://{1}/")
        }
)
public class HomePage extends PageObject{

        public void goToAllElectronics(){
                find(By.linkText("Electronics")).click();
        }

        public String getBrands(){
                return $("//h4[text()='Featured Brands']/following-sibling::ul/div/li").getText();
        }

        public  void loginUser(){
                getDriver().findElement(By.linkText("Sign in")).click();
                find(By.id("userid")).sendKeys("testmoni@gmail.com");
                find(By.id("pass")).sendKeys("testebay@123");
                find(By.id("sgnBt")).click();
        }

        public void goForAppleLaptops(){
                find(By.linkText("Laptops & Tablets")).click();
                find(By.linkText("Apple Laptops")).click();
        }

        public void selectaProduct(){
                WebElementFacade product = find(By.cssSelector(".b-module.b-list.b-listing > ul li .s-item__link"));
                product.waitUntilVisible();
                //withAction().moveToElement(product);
                evaluateJavascript("scroll(0, 750);");
                product.click();
        }

        public void clickOnBuyNow(){
                find(By.id("binBtn_btn")).click();
        }
}
