package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver =new FirefoxDriver();
        driver.get("https://erpstaging.brac.net/node/mfDashboard#!/memberInfo/index");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

         //By id
        //driver.findElement(By.id("username_txt")).sendKeys("00043992");
        WebElement element= driver.findElement(By.id("username_txt"));
        element.clear();
        element.sendKeys("00043992");

        WebElement element1= driver.findElement(By.id("password"));
        element1.clear();
        element1.sendKeys("abc123$");
        Thread.sleep(2000);

        //By tagName
        driver.navigate().to("https://demoqa.com/text-box");
        driver.findElement(By.tagName("textarea")).sendKeys("Rajbari");
        Thread.sleep(2000);

       //By Name
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
        driver.findElement(By.name("username")).sendKeys("00165228");
        driver.findElement(By.name("password")).sendKeys("abc123$");
        Thread.sleep(2000);

        //By Classname
        driver.navigate().to("https://parabank.parasoft.com/parabank/services.htm");
        driver.findElement(By.className("Solutions")).click();
        Thread.sleep(2000);

        //By LinkText
        driver.findElement(By.linkText("Services")).click();    //<a >services
        Thread.sleep(2000);

        //By partialLinkText
       // driver.findElement(By.partialLinkText("t U")).click();
        Thread.sleep(2000);

        //By cssSelector
        driver.findElement(By.cssSelector(".leftmenu a[href='services.htm']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
