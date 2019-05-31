import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest extends AppiumServer {
    public static AndroidDriver<AndroidElement> driver;
    public static WebDriverWait wait;
    protected static PropertiesLoader prop;

    @BeforeMethod
    public void setupEmulator() throws IOException {
        prop = new PropertiesLoader();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/main/java/apkFile/");
        File app = new File(appDir.getCanonicalPath(), prop.getApkFileName());
        startServer();
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName", prop.getDeviceName());
        cap.setCapability("udid", prop.getUdId());
        cap.setCapability("platformName", prop.getPlatformName());
        cap.setCapability("app", app.getAbsolutePath());
        cap.setCapability("platformVersion", prop.getPlatformVersion());
        cap.setCapability("appPackage", prop.getAppPackage());
        cap.setCapability("appActivity", prop.getAppActivity());
        cap.setCapability("newCommandTimeout", 600 * 5);
        driver = new AndroidDriver<AndroidElement>(getServiceUrl(), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        driver.resetApp();
    }

    @AfterMethod
    public void tearDown() {
        stopServer();
        driver.quit();
    }

    public AndroidElement findElementById(String id) {
        return (AndroidElement) wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }
    public AndroidElement waitForElement(AndroidElement element) {
       return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public AndroidElement findElementByXpath(String xPath) {
        return (AndroidElement) wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public AndroidElement findElementByClass(String className) {
        return (AndroidElement) wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void waitUntilElementAppears(AndroidElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementDisappears(AndroidElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
