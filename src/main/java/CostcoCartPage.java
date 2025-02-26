import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

// page_url = https://www.costco.com/CheckoutCartDisplayView
public class CostcoCartPage extends Base{
//    public CostcoCartPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//

    @FindBy(css = "input[name='continue-shopping']")
    WebElement continueShoppingButton;

    String expectedUrl = "https://www.costco.com/";

    @FindBy(css = "#footer-search-field")
    WebElement findStore;

    // testcase: verify the Cart header


void clickContinueShopping(){
    explicitlyWait(continueShoppingButton);
    continueShoppingButton.click(); // after clicking this we reach the homepage
    // race condition, the url is fetched too quickly
    Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
}

void searchForAStore(String x){
    explicitlyWait(findStore);
    findStore.sendKeys(x+ Keys.ENTER);
}



}