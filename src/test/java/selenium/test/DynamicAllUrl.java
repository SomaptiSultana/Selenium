package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DynamicAllUrl {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://erpdevelopment.brac.net/node/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement username = driver.findElement(By.cssSelector("input[name*='j_username_txt']"));
        username.clear();
        username.sendKeys("00115680");
        WebElement username1 = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        username1.clear();
        username1.sendKeys("abc123$");
        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();

        //using findElements
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        if (links.size() != 0) {

            for (WebElement webElement : links) {
                String link = webElement.getAttribute("href");
                // String linkValue = link != null ? link : "";

                if (link != null && !link.isEmpty() && !link.equals("")) {
                    System.out.println(link);
                }
            }
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
