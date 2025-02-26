import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// page_url = https://www.macys.com/
public class MacysHomePage extends Base{


    @FindBy(css = ".footer-links-group ul li a")
    List<WebElement> footerLinx;



    protected void scrapeTitleLinkIntoDB(String t, String fL) {

        String query = "INSERT INTO macysfooterlinks (title,footerlink) VALUES (?,?)";

        try (Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:macysfooter.sqlite");
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1,t);
            statement.setString(2,fL);

            // Execute the query (use executeUpdate for INSERT)
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Title & Link scraped into DB xD");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void getFooter(){
    scrollToElement(footerLinx.getFirst());
        LinkedList<String> title = new LinkedList<>();
        LinkedList<String> footerLink = new LinkedList<>();
        for(WebElement f : footerLinx){title.add(f.getText());}
        for(WebElement f : footerLinx){footerLink.add(f.getDomProperty("href"));}

        // for each title & link from the LinkedList, feed to the DB
        for (int i = 0; i < footerLinx.size(); i++) {
            String t = title.get(i);
            String fL = footerLink.get(i);
            scrapeTitleLinkIntoDB(t, fL);
        }

    }






}