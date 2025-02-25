import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.macys.com/
public class MacysHomePage {
    public MacysHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }



}