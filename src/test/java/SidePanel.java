import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BaseTest;

/**
 * This is left panel page class, which contains list of projects, counts of task, selecting project by name etc
 * From this page user can add a new project as well.
 */

public class SidePanel extends BaseTest {
    public SidePanel(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SidePanel expandProject() {
        expandItemByName("Projects");
        return this;
    }

    public SidePanel expandItemByName(String itemNameToExpand){
        findElementByXpath("//android.widget.RelativeLayout/android.widget.TextView[@text='"+itemNameToExpand+"']/following-sibling::android.widget.ImageView").click();
        return this;
    }

    public SidePanel verifyProjectByName(String projectName) {
        findElementById("android:id/content");
        int projectsList = driver.findElementsByXPath("//android.widget.RelativeLayout/android.widget.TextView[@text='" + projectName + "']").size();
        Assert.assertTrue(projectsList > 0, "Project with name " + projectName + " not found");
        return this;
    }

    public MainTaskList clickOnProjectByName(String projectName) {
        verifyProjectByName(projectName);
        findElementByXpath("//android.widget.RelativeLayout/android.widget.TextView[@text='" + projectName + "']").click();
        return new MainTaskList(driver);
    }

    public void addProject() {
        findElementById("com.todoist:id/add").click();
    }

    public MainTaskList openProjectByName(String projectName){
        expandProject();
        return clickOnProjectByName("Javed");
    }
}
