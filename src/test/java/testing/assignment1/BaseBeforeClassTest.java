package testing.assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseBeforeClassTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setUpBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver =new FirefoxDriver();
        driver.get("https://erpstaging.brac.net/node/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

