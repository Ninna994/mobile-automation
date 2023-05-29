package me.amplitudo;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppiumBasicsTest extends Base{

    @Test
    public void appiumTest() {
        //actual code start
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Nikolina Test");
        driver.findElements(By.className("android.widget.Button")).get(1).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String textInserted = driver.findElement(By.className("android.widget.EditText")).getText();
        System.out.println(textInserted);
        Assert.assertEquals(textInserted, "Nikolina Test");

    }
}

