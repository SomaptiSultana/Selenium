package testing.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BeforeClassTest extends BaseBeforeClassTest {
    @Test(priority = 0)
    public void checkTittleShouldSucceed(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle().trim(), "..::LOGIN::..");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (priority = 1)
    public void checkLoginPageShouldSucceed(){
        String loginText = driver.findElement(By.cssSelector(".floatL")).getText().trim();
        Assert.assertEquals(loginText, "Sign-in");
    }

    @Test(priority = 2)
    public void loginShouldSucceed() throws InterruptedException {
        WebElement username = driver.findElement(By.name("j_username_txt"));
        username.clear();
        username.sendKeys("00043992");

        WebElement password = driver.findElement(By.name("j_password"));
        password.clear();
        password.sendKeys("abc123$");

        driver.findElement(By.cssSelector("button[class='submit btn btn-primary']")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".btn_user")).click();



        String logoutLinkTxt= driver.findElement(By.linkText("Logout")).getText().trim();
        Assert.assertEquals(logoutLinkTxt, "Logout");
    }

}


