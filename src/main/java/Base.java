import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    static WebDriver driver;


    void invokeBrowser(String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    void impWait(Integer seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    void explicitWait(Integer seconds, WebElement element){
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
        wait.until(w->element.isDisplayed());
    }


    void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    void deleteElement(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].remove();", element);
    }

    void dropDownInteraction(WebElement dropdown,int sb, int index,String text){
        Select select = new Select(dropdown);
        switch(sb){
            case(1)-> select.selectByIndex(index);
            case(2)-> select.selectByValue(text);
            case(3)->select.selectByVisibleText(text);
        }
    }




}
