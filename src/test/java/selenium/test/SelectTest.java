package selenium.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        //driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.get("https://erpstaging.brac.net/node/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement username = driver.findElement(By.cssSelector("input[name*='j_username_txt']"));
        username.clear();
        username.sendKeys("00115680");

        WebElement username1 = driver.findElement(By.cssSelector("input[name^='j_pass']"));
        username1.clear();
        username1.sendKeys("abc123$");

        driver.findElement(By.cssSelector("button[class$='btn-primary']")).click();
        //driver.findElement(By.cssSelector("form.login-form")).submit();
        Thread.sleep(3000);

        //Browser navigate
        driver.navigate().to("https://erpstaging.brac.net/node/mfDashboard#!/loanProposal/create");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Single Select
       // WebElement project=driver.findElement(By.cssSelector("select[id='project_info_id']"));
        Select select =new Select(driver.findElement(By.cssSelector("select[id='project_info_id']")));
        //Select select =new Select(project_info_id);

        //Select option
        select.selectByValue("1");        //By value
        Thread.sleep(2000);

        select.selectByIndex(5);          //By index
        Thread.sleep(2000);

        select.selectByVisibleText("[60] - Progoti");              //By Text
        //select.getOptions();          //returns list of web element

        for (WebElement option: select.getOptions()){              //All options
            System.out.println(option.getText());
        }

    }

}
