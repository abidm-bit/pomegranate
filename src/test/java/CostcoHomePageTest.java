import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CostcoHomePageTest extends Base{
    CostcoHomePage chp;

    @BeforeMethod
    void setUp(){
        invokeBrowser("https://www.costco.com/");
        chp = PageFactory.initElements(driver, CostcoHomePage.class);
    }

    @Test(priority = 0)
    void logo(){
        chp.logo();
    }


    @Test(priority = 1)
    void search(){
        chp.search4Product("tv");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.costco.com/s?keyword=tv");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
