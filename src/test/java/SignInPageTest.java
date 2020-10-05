import company.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        // win Mac linux
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        signInPage = new SignInPage(this.driver);
    }

    @Test
    public void canRegisterAccount() throws InterruptedException {
        Assert.assertTrue(
                signInPage.openMainPage()
                        .openSignInPage()
                        .editEmailField()
                        .pressButtonCreateAccount()
                        .editAllFieldsInRegisterPage()
                        .pressButtonRegister()
                        .isErrorMessageAppears());
    }

    @After
    public void cleanup(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
