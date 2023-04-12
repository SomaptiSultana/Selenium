package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DynamicInformation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://erpdevelopment.brac.net/node/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        System.out.println(driver.findElement(By.cssSelector(".logo .img-responsive")).getAttribute("src"));

        WebElement username = driver.findElement(By.cssSelector("input[name*='j_username_txt']"));
        username.clear();
        username.sendKeys("00115680");
        WebElement username1 = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        username1.clear();
        username1.sendKeys("abc123$");

        //Information about web elements
        System.out.println(username.isDisplayed());
        System.out.println(username.getTagName());
        System.out.println(username.getCssValue("font-size").trim());
        System.out.println(username.getRect().x+ " " + username.getRect().y);
        System.out.println(driver.findElement(By.linkText("BRAC, Bangladesh")).getText().trim());

        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();
        //driver.findElement(By.cssSelector("form.login-form")).submit();

        Thread.sleep(3000);
        driver.quit();
    }
}
