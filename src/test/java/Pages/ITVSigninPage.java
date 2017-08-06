package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by admin on 01/08/2017.
 */
public class ITVSigninPage {

    @FindBy(css = "#login-email")
    public static WebElement email;

    @FindBy(css = "#login-password")
    public static WebElement password;

    @FindBy(css = "#login-submit")
    public static WebElement submit;

}
