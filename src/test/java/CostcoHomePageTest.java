import org.openqa.selenium.support.PageFactory;
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

    // 3 entries, so this test will run 3 times
    @DataProvider(name ="product")
    public Object[][] keyword(){
        return new Object[][]{
                {"tv","https://www.costco.com/televisions.html"},
                {"paper","https://www.costco.com/office-paper.html"},
                {"golf","https://www.costco.com/sports-fitness-golf.html"}
        };
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
