import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

/**
 * This class can be used to handle all scroll related functions.
 */
public class Scroller {


    /**
     * This method will scroll the list based on screen size and, each scroll will perform the
     * half size screen scroll
     * @param driver
     */
    public void scrollDown(AndroidDriver driver){
        Dimension dimension = driver.manage().window().getSize();
        Double scrollHieghtStart = dimension.getHeight()*0.5;
        int scrollStart = scrollHieghtStart.intValue();
        Double scrollHightEnd = dimension.getHeight() *0.2;
        int scrollEnd = scrollHightEnd.intValue();
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0,scrollStart))
                .moveTo(PointOption.point(0,scrollEnd))
                .release().perform();

    }
}
