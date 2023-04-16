package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        //driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Simple Alert/alert
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //Confirm Button
        driver.findElement(By.id("confirmButton")).click();
        Alert ConfirmAlert=driver.switchTo().alert();    //Object
        System.out.println(ConfirmAlert.getText());
        ConfirmAlert.dismiss();
        Thread.sleep(2000);

        //prompt Button
        driver.findElement(By.id("promtButton")).click();
        Alert PromptAlert=driver.switchTo().alert();    //Object
        PromptAlert.sendKeys("Somapti");
        Thread.sleep(2000);
        System.out.println(PromptAlert.getText());
        Thread.sleep(2000);
        PromptAlert.accept();
        Thread.sleep(2000);

        driver.quit();

    }
}
