package Steps;

import Actions.HomeAction;
import Actions.SigninAction;
import Base.ConfigReader;
import Pages.ITVHomePage;
import Pages.ITVSigninPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 02/08/2017.
 */
public class ITVTest {

    public WebDriver driver;

    String firstname = ConfigReader.user.getProperty("firstname");
    String itvCh = ConfigReader.user.getProperty("itvChannel");
    String userName = ConfigReader.user.getProperty("email");
    String passWord = ConfigReader.user.getProperty("password");
    String selectShow = ConfigReader.user.getProperty("showStartWith");

    public ITVTest() {
        driver = Hooks.driver;
    }

    @Given("^Open the ITV Homepage$")
    public void open_the_ITV_Homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, ITVHomePage.class);
        //HomeAction.ITVHomePage();
        HomeAction.clickToSignInPage();
    }

    @When("^Click the Sign-in Button$")
    public void click_the_Sign_in_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HomeAction.clickToSignInPage();
    }

    @When("^Enter the Email and Password$")
    public void enter_the_Email_and_Password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PageFactory.initElements(driver, ITVSigninPage.class);
        PageFactory.initElements(driver, ITVHomePage.class);
        SigninAction.Login(userName, passWord);

    }

    @When("^Click the Sign-In Button$")
    public void click_the_Sign_In_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        SigninAction.clickSigninbtn();

    }

    @When("^Verify the NavBar-Name same as User-FirstName$")
    public void verify_the_NavBar_Name_same_as_User_FirstName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String t = wait.until(ExpectedConditions.visibilityOf(ITVHomePage.firstName)).getText();
        Assert.assertEquals(firstname, t);
        System.out.println("ITV HOME_PAGE : Navigation Bar [USER'S-FIRST NAME] :" + t);
        System.out.println("-------------------------------------------------------------------------");

    }

    @When("^Verify the ITV Channels are displayed$")
    public void verify_the_ITV_Channels_are_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<String> itvchannels = new ArrayList<String>();
        itvchannels.add(itvCh);
        System.out.println("ITV HOME_PAGE :  Expected Channels(Given Manually)  :" + itvchannels);
        List<String> Actual = new ArrayList<String>();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        for (WebElement e : wait.until(ExpectedConditions.visibilityOfAllElements(ITVHomePage.itvChannels))) {
            if (!e.getText().trim().isEmpty())
                Actual.add(e.getText().trim());
        }
        System.out.println("ITV HOME_PAGE :  Actual Channels  - ITV Page :" + Actual);

        System.out.println();
        System.out.println("------------------------------------------------------------------------ ");

    }

    @When("^Click on Shows from NavBar$")
    public void click_on_Shows_from_NavBar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^Count and print all the Shows that start with A$")
    public void count_and_print_all_the_Shows_that_start_with_A() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HomeAction.selectShowsStartWith(selectShow);
    }

    @Then("^Click on Sign-Out Button$")
    public void click_on_Sign_Out_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        HomeAction.clicksignOut();
    }

}
