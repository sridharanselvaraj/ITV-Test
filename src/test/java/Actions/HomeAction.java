package Actions;

import Base.ConfigReader;
import Pages.ITVHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by admin on 02/08/2017.
 */
public class HomeAction {


    public static WebDriver driver;


    public static void ITVHomePage() {
        String url = ConfigReader.user.getProperty("bashUrl");
        System.out.println("Navigating to ITV.com:" + url);
        driver.get(url);
    }

    public static void clickToSignInPage() {
        System.out.println("ITV HOME_PAGE : Clicking the [SignIn] Link.");
        ITVHomePage.signIn.click();
        System.out.println("ITV HOME_PAGE : Navigating to the SignIn_Page .\n");
    }

    public static void selectShowsStartWith(String showsStartwith) {

        ITVHomePage.shows.click();

        System.out.println("ITV SHOWS_PAGE : Start With [A] :" + ITVHomePage.alphateCompare.getText());

        int count = 0;

        if (ITVHomePage.alphateSelect.getText().equalsIgnoreCase(showsStartwith)) {

            ITVHomePage.alphateSelect.click();

            if (ITVHomePage.alphateSelect.getText().equals(ITVHomePage.alphateCompare.getText())) {

                List<WebElement> d = ITVHomePage.listofSelectedPrograms;

                for (WebElement element : d) {
                    System.out.println("ITV SHOWS_PAGE :List Of Programe :" + element.getText());
                    count++;
                    if (element.getText().isEmpty()) break;

                }
                System.out.println("ITV SHOWS_PAGE : COUNT : " + count);
            }

        }

    }


    public static void clicksignOut() {

        ITVHomePage.userSignIn.click();
        ITVHomePage.signOut.click();

    }


}
