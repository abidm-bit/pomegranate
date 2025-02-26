import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CostcoHomePageTest extends Base{
    CostcoHomePage chp;

    @BeforeMethod
    void setUp(){
    //  going to feed this in the runner.xml later
        invokeBrowser("https://www.costco.com/");
        chp = PageFactory.initElements(driver, CostcoHomePage.class);
    }

    @Test(priority = 0)
    void logo(){
        chp.logo();
    }

    // going to feed products into the search parameter using DataProvider
    // or fetch from a db , maybe a sqlite db in this project
    // fetch from a DB -> 2D array -> DataProvider
    @Test(priority = 1)
    void search(){
        chp.search4Product("tv");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
