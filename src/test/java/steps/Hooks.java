package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUp() {
        // Tentukan lokasi driver
        System.setProperty("webdriver.chrome.driver", "D:\\JAYJAY\\AUTO API\\tugas19new\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");

        // Inisialisasi WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
