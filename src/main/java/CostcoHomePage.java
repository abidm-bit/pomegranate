import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class CostcoHomePage extends Base {


    @FindBy(css=".mui-xp74xe .mui-saptuz .mui-hweoo8 .mui-mniee")
    public WebElement logo;

    @FindBy(css = "input[placeholder='Search Costco']")
    public WebElement searchBox;

    public void logo(){
        explicitWait(7,logo);
       Assert.assertTrue(logo.isDisplayed());
    }

    public void search4Product(String product){
        searchBox.isDisplayed(); searchBox.isEnabled();
        searchBox.sendKeys(product + Keys.ENTER);
    }



}