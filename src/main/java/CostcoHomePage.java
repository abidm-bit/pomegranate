import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

// page_url = https://www.costco.com/
public class CostcoHomePage extends Base {

@FindBy(css="input[aria-label=\"Search Costco\"]") WebElement searchBox;

void searchFor(String kw, String url) throws InterruptedException {
    explWaitElementDisplay(searchBox,3);
    moveToElement(searchBox);
    searchBox.sendKeys(kw + Keys.ENTER);
    Thread.sleep(Duration.ofSeconds(3)); 
    Assert.assertEquals(driver.getCurrentUrl(),url);
}



}