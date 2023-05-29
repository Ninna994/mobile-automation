package me.amplitudo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumGesturesTest extends Base{
    @Test
    public void longClickTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        //long click
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        longPressAction(element);

        String firstMenuItemText = driver.findElements(By.id("android:id/title")).get(0).getText();
        Assert.assertEquals(firstMenuItemText, "Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
        Thread.sleep(1000);
    }

    @Test
    public void scrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollIntoView("WebView");
    }

    @Test
    public void scrollToEndTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToEndAction();
    }

    @Test
    public void swipeTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        WebElement secondImage = driver.findElement(By.xpath("(//android.widget.ImageView)[2]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        //one swipe
        swipeToElementAction(secondImage, "left");
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
    }

    @Test
    public void dragAndDropTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

    }
}
