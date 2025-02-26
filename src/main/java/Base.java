import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    static WebDriver driver;
    static JavascriptExecutor javascriptExecutor;
    static Wait<WebDriver> wait; // might not have to make this static, move back to line 23

    void invokeBrowser(String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // invoke the browser in incognito mode
        driver.get(url);
    }

    void explicitlyWait(WebElement element){
        // update this to pass the int for duration of seconds
        wait = new WebDriverWait(driver,Duration.ofSeconds(9));
        wait.until(w->element.isDisplayed());
    }

    void dropDown(WebElement element){
        Select select = new Select(element);
        // switch for multiple select options ?
    }



    void deleteElement(WebElement element){
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].remove();", element);
    }





}
