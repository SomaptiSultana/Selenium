package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DynamicInteracting {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("http://10.42.53.130:9099/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Dynamic locators
        WebElement username = driver.findElement(By.cssSelector("input[name*='j_username_txt']"));
        username.clear();
        username.sendKeys("00115680");

        WebElement username1 = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        username1.clear();
        username1.sendKeys("abc123$");

        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();
        //driver.findElement(By.cssSelector("form.login-form")).submit();

        Thread.sleep(3000);
        driver.quit();
    }
}


