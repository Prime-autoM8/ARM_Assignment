package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Map;

public class MailToSelf extends SetUp.base{

    WebDriver driver = getDriver();
    public Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

//    Page Objects
    By eMail = By.id("identifierId");
    By pWd = By.xpath("//*[@name='password']");
    By nextButton = By.xpath("//span[contains(text(),'Next')]");
    By profileImage = By.xpath("//*[@class='gb_Aa gbii']");
    By composeButton = By.xpath("//div[contains(@class, 'T-I-KE')]");
    By messageModal = By.xpath("*//h2/div[2]/span[contains(text(),'New Message')]");
    By rcpnt = By.name("to");
    By sbjt = By.name("subjectbox");
    By bdy = By.xpath("//div[contains(@class, 'editable')]");
    By sendMessage = By.xpath("//div[contains(@class, 'J-J5-Ji aoO')]");
    By newAlert = By.xpath("//tr[contains(@class, 'zA zE')]/td[4]/div[2]/span/span[@email='seleniumautotest7@gmail.com']");



    @Given("User is on {string}")
    public void user_is_on_www_gmail_com(String URL) {
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }
   @When("User Login using below credentials")
    public void user_login_using_below_credentials(io.cucumber.datatable.DataTable creds) {
       Map<String, String> loginCredentials = creds.asMap(String.class, String.class); //Convert DataTable to List of Maps
       wait.until(ExpectedConditions.visibilityOfElementLocated(eMail));
       driver.findElement(eMail).sendKeys(loginCredentials.get("username"));
       clickNextButton();
       wait.until(ExpectedConditions.visibilityOfElementLocated(pWd));
       driver.findElement(pWd).sendKeys(loginCredentials.get("password"));
       clickNextButton();


    }
    @Then("system grants user access successfully")
    public void system_grants_user_access_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileImage));
        WebElement displayedProfileImage = driver.findElement(profileImage);
        Assert.assertTrue(displayedProfileImage.isDisplayed());
    }
    @When("User clicks on create new mail")
    public void user_clicks_on_create_new_mail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(composeButton));
        driver.findElement(composeButton).click();
    }
    @Then("System displays new mail modal")
    public void system_displays_new_mail_modal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageModal));
        WebElement displayedMessageModal = driver.findElement(messageModal);
        Assert.assertTrue(displayedMessageModal.isDisplayed());
    }
    @When("User provides email details as stated below")
    public void user_provides_email_details_as_stated_below(io.cucumber.datatable.DataTable messg) {
        Map<String, String> messgContents = messg.asMap(String.class, String.class); //Convert DataTable to List of Maps
        wait.until(ExpectedConditions.visibilityOfElementLocated(rcpnt));
        driver.findElement(rcpnt).sendKeys(messgContents.get("recipient"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sbjt));
        driver.findElement(sbjt).sendKeys(messgContents.get("subject"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bdy));
        driver.findElement(bdy).sendKeys(messgContents.get("body"));


    }
    @When("User clicks the send button")
    public void user_clicks_the_send_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessage));
        driver.findElement(sendMessage).click();
    }
    @Then("user receives email successfully")
    public void user_receives_email_successfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newAlert));
        String mailer = driver.findElement(newAlert).getText();
        Assert.assertEquals(mailer,"me");
    }


}
