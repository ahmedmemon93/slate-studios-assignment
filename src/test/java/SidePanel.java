import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SidePanel extends BaseTest {
    public SidePanel(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SidePanel expandProject() {
        findElementByXpath("(//android.widget.ImageView[@content-desc=\"Expand/collapse\"])[1]").click();
        return this;
    }

    public SidePanel verifyProjectByName(String projectName) {
        findElementById("android:id/content");
        int projectsList = driver.findElementsByXPath("//android.widget.RelativeLayout/android.widget.TextView[@text='" + projectName + "']").size();
        Assert.assertTrue(projectsList > 0, "Project with name " + projectName + " not found");
        return this;
    }

    public void addProject() {
        findElementById("com.todoist:id/add").click();
    }
}
