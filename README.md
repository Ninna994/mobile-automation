
## Appium setup

* Maven repository dependencies needed
    * [Java client](https://mvnrepository.com/artifact/io.appium/java-client)
* Node.js version on computer - 16+ - check `node -v`
* Appium 2.0+ - check `appium -v`
* Check if uiautomator is installed - run `appium driver list`
    * if not installed run install commands `appium driver install uiautomator2` and similar for rest of needed drivers

### Driver setup

```java
    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName("Pixel 3");
    options.setApp("C:\\Users\\inani\\Desktop\\mobileAutomationAmplitudo\\src\\main\\resources\\apks\\ApiDemos-debug.apk");
    
    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    driver.quit();
```

### Appium - starting server programmatically

* `@Before` hook
```java
    AppiumDriverLocalService service = new AppiumServiceBuilder()
        .withAppiumJS(new File("C:\\Users\\inani\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
        .withIPAddress("http://127.0.0.1")
        .usingPort(4723)
        .build();
    service.start()
```

*`@After` hook

```java
    service.stop();
```
### Several notes about switching to mobile automation

* Locators
    * Instead of using `By` we use `AppiumBy` for mobile locators
        * accessibilityID
        * className - by recommendation
    * For all other locator strategies we can use By from selenium
      * xpath, id etc. 
* [Mobile Gestures](https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md)
* Scroll into view using UiAutomator
  * `        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
    `
* 


