import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CostcoCartPageTest extends Base{
    CostcoCartPage ccp;

    @BeforeMethod
    void setUp(){
        invokeBrowser("https://www.costco.com/CheckoutCartDisplayView");
        ccp = PageFactory.initElements(driver,CostcoCartPage.class);
    }

    @Test(priority = 0)
    void continueShopping(){
        ccp.clickContinueShopping();
    }

    @Test(priority = 1)
    void searchForStore(){
        ccp.searchForAStore("11427");
        Assert.assertTrue(driver.getCurrentUrl().contains("location=11427"));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }


}
