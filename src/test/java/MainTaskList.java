import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

public class MainTaskList extends BaseTest {
    public MainTaskList(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SidePanel openLeftPanel() {
        findElementByXpath("//android.widget.ImageButton[@content-desc=\"Change the current view\"]")
                .click();
        return new SidePanel(driver);
    }
}
