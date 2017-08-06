package Steps;

import Base.ConfigReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

/**
 * Created by admin on 28/07/2017.
 */
public class Hooks {

    public static WebDriver driver;

    @Before
    public void openBrower() throws MalformedURLException {
        String url = ConfigReader.user.getProperty("bashUrl");
        System.out.println("Navigating to ITV.com:"+url);
        System.setProperty("webdriver.chrome.driver", "src/test/Resoureces/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void closeBrower(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Get title URL :" + driver.getTitle());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");

            } catch (WebDriverException we) {
                System.out.println("Webdriver Error Message " + we.getMessage());
            }
        }
       driver.quit();
    }
}


