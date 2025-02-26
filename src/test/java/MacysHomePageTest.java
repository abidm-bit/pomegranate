import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MacysHomePageTest extends Base{
    MacysHomePage mhp;

    @BeforeMethod
    void setUp(){
        invokeBrowser("https://www.macys.com/");
        mhp = PageFactory.initElements(driver, MacysHomePage.class);
    }

    @Test
    void scrapeFoot(){
        mhp.getFooter();
        // BeforeClass , run a query to delete all records
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
