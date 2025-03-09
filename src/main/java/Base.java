import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Base {

    static WebDriver driver;

    // driver.get() method
    void goToSite1(String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    // navigate().to() method
    void goToSite2(String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    void implWait(int duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    void explWaitElementDisplay(WebElement element, int duration){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(e->element.isDisplayed());
    }



    // Scrolls the page so that the element becomes visible in the viewport
    // doesn't move the mouse to the element
    void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    // Moves the mouse to the center of the element
    // Useful for triggering hover events , mouse hover
    void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // indices start with 0
    void dropDownIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    void dropDownText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    void dropDownValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    void scrollToElement2(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    boolean checkIfPricesAreSorted(ArrayList<String> input){
    ArrayList<Double>process = new ArrayList<>();
    for(String all:input){
        all=all.replaceAll("\\$","");
        process.add(Double.parseDouble(all));
    }
        for(int i=1;i<process.size();i++){
            if(process.get(i-1).compareTo(process.get(i))>0){ return false;}
        }return true;
    }




}
