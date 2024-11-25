package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver","C:\\Learning\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        Hooks.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        Hooks.driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Hooks.driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        Hooks.driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        assertTrue(Hooks.driver.getCurrentUrl().contains("inventory"));

    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        Hooks.driver.findElement(By.id("user-name")).sendKeys("invalid_user");
        Hooks.driver.findElement(By.id("password")).sendKeys("wrong_password");
        Hooks.driver.findElement(By.id("login-button")).click();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        String errorMessage = Hooks.driver.findElement(By.cssSelector(".error-message-container")).getText();
        System.out.println("Error Message: " + errorMessage); // Debug pesan kesalahan
        Assert.assertTrue("Error message not displayed", errorMessage.contains("Epic sadface"));
    }

    @When("I leave the fields empty")
    public void iLeaveTheFieldsEmpty() {
        Hooks.driver.get("https://www.saucedemo.com/");
        Hooks.driver.findElement(By.id("login-button")).click();
    }
}
