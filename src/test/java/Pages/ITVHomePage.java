package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by admin on 01/08/2017.
 */
public class ITVHomePage {

    @FindBy(css = "#nav-primary-login")
    public static WebElement signIn;
    @FindBy(css = "#nav-primary-user-menu > span[class='nav-primary__user-name ellipsis js-user-name']")
    public static WebElement firstName;

    @FindBy(css = "#now-next > ul > li > a > h3")
    public static List<WebElement> itvChannels;

    @FindBy(css = "#nav-primary-a-z")
    public static WebElement shows;

    @FindBy(css = ".nav-secondary__link.js-sticky-anchor")
    public static WebElement alphateSelect;


    @FindBy(css = "#a > h2")
    public static WebElement alphateCompare;


    @FindBy(css = "#a > ul > li:nth-child(n) > a > article > div.media__body.tout__body > header > h3")
    public static List<WebElement> listofSelectedPrograms;

    @FindBy(css = "#nav-primary-user-menu")
    public static WebElement userSignIn;

    @FindBy(css = "#nav-primary-logout")
    public static WebElement signOut;


}
