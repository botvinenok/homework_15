package company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private static final String MAIN_PAGE_URL ="http://automationpractice.com";
    private WebDriver driver;

    private By buttonSignIn = By.xpath("//a[@class='login']");
    private By fieldEmailCreateAcc = By.xpath("//input[@id='email_create']");
    private By buttonCreateAcc = By.xpath("//button[@id='SubmitCreate']");
    private By errorCreateAccMessage = By.xpath("//div[@class='alert alert-danger']//p");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage openMainPage(){
        this.driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public SignInPage openSignInPage(){
        this.driver.findElement(buttonSignIn).click();
        return this;
    }

    public SignInPage editEmailField() throws InterruptedException {
        this.driver.findElement(fieldEmailCreateAcc).sendKeys("den@mail.ru");
        return this;
    }

    public SignInPage pressButtonCreateAccount() throws InterruptedException {
        this.driver.findElement(buttonCreateAcc).click();
        Thread.sleep(10000);
        return this;
    }

    public SignInPage editAllFieldsInRegisterPage(){
        this.driver.findElement(By.xpath("//input[@id='customer_firstname']"))
                .sendKeys("Gena");
        this.driver.findElement(By.xpath("//input[@id='lastname']"))
                .sendKeys("Gvuh");
        this.driver.findElement(By.xpath("//input[@id='address1']"))
                .sendKeys("street BEstWay 10");
        this.driver.findElement(By.xpath("//input[@id='city']"))
                .sendKeys("Heaven");
        this.driver.findElement(By.xpath("//input[@id='postcode']"))
                .sendKeys("030902");
        this.driver.findElement(By.xpath("//input[@id='phone_mobile']"))
                .sendKeys("0931055859");
        this.driver.findElement(By.xpath("//input[@id='alias']"))
                .sendKeys("Smth i need to write here");
        return this;
    }

    public SignInPage pressButtonRegister() throws InterruptedException {
        this.driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
        Thread.sleep(10000);
        return this;
    }

    public boolean isErrorMessageAppears(){
        String message = this.driver.findElement(errorCreateAccMessage).getText();
        return message.toLowerCase().trim().contains("error") ? true: false;
    }


}
