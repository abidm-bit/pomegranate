import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class CostcoHomePageTest extends Base{
    CostcoHomePage chp;

    @BeforeMethod
//    @Parameters({"url"})
//    void setUp(String url){
    void setUp(){
        goToSite1("https://www.costco.com/");
        chp = PageFactory.initElements(driver,CostcoHomePage.class);
    }

    @DataProvider(name ="product")
    public Object[][] keyword(){
        return new Object[][]{{"tv","https://www.costco.com/televisions.html"}};
    }

    @Test(dataProvider = "product")
    void verifySearchUrl(String keyword,String url) throws InterruptedException {
        chp.searchFor(keyword,url);
    }





    @AfterMethod
    void tearDown(){
        driver.quit();
    }


}
