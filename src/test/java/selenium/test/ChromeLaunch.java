package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
