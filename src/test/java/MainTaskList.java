import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainTaskList extends BaseTest {
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Change the current view\"]")
    private AndroidElement leftPanelMenu;
    @FindBy(id = "com.todoist:id/profile_view_avatar")
    private AndroidElement profileAvatar;
    @FindBy(id = "com.todoist:id/fab")
    private AndroidElement addTaskBtn;
    @FindBy(id = "com.todoist:id/schedule")
    private AndroidElement scheduleTask;
    @FindBy(id = "com.todoist:id/menu_item_complete")
    private AndroidElement completeTask;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private AndroidElement moreOptions;
    @FindBy (id = "android:id/message")
    private AndroidElement addTaskInputBox;
    @FindBy (id = "android:id/list")
    private AndroidElement taskListPanel;


    public MainTaskList(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public SidePanel openLeftPanel() {
        leftPanelMenu.click();
        Assert.assertTrue(profileAvatar.isDisplayed(), "Profile Image on left panel is not visible");
        return new SidePanel(driver);
    }

    public AddTask clickOnAddTaskBtn() {
        addTaskBtn.click();
        Assert.assertTrue(addTaskInputBox.isDisplayed(), "Add task text inputbox is not present");
        Assert.assertTrue(scheduleTask.isDisplayed(), "while adding new task schedule option is not present");
        return new AddTask(driver);
    }

    public MobileElement getLastElement() {
        int listSize = taskListPanel.findElementsByXPath(".//android.widget.TextView").size();
        return taskListPanel.findElementsByXPath(".//android.widget.TextView").get(listSize - 1);
    }

    public void verifyTaskIsPresentInList(String taskName) {
        List<MobileElement> taskList = taskListPanel.findElementsByXPath(".//android.widget.TextView[contains(@text,'" + taskName + "')]");
        Scroller scroller = new Scroller();
        while (taskListPanel.findElementsByXPath(".//android.widget.TextView[contains(@text,'" + taskName + "')]").size() == 0) {
            int beforeScroll = getLastElement().getCenter().y;
            scroller.scrollDown(driver);
            int afterScroll = getLastElement().getCenter().y;
            if (beforeScroll == afterScroll) {
                System.out.println("reached at the end");
                break;
            }
        }
        Assert.assertTrue(taskListPanel.
                findElementsByXPath(".//android.widget.TextView[contains(@text,'" + taskName + "')]").get(0).isDisplayed(), "Task not created");
    }

    public MainTaskList clickOnTaskByName(String taskName) {
        verifyTaskIsPresentInList(taskName);
        taskListPanel.
                findElementsByXPath(".//android.widget.TextView[contains(@text,'" + taskName + "')]").get(0).click();
        Assert.assertTrue(findElementById("com.todoist:id/menu_item_complete").isDisplayed(), "Task actions are not displayed");
        return this;
    }

    public MainTaskList completeTask() {
        completeTask.click();
        Assert.assertTrue(findElementById("com.todoist:id/snackbar_text").getText().contains("Completed."), "On task completion success message not appearing/correct");
        return this;
    }

    public MainTaskList selectMoreOption(String optionName) {
        moreOptions.click();
        AndroidElement and = findElementByXpath("//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout");
        System.out.println("valueIs:"+ and.getLocation().getY()+" x: " +and.getLocation().getX());
        findElementByXpath("//android.widget.LinearLayout//android.widget.TextView[@text='" + optionName + "']").click();
        return this;
    }

    public CompletedTaskList goToCompleteTask() {
        selectMoreOption("Completed tasks");
        Assert.assertEquals(findElementById("com.todoist:id/toolbar").findElementByXPath("//android.widget.TextView").getText(),
                "Completed tasks", "List header is not correct");
        Assert.assertTrue(taskListPanel.isDisplayed(), "Completed task list is not visible");
        return new CompletedTaskList(driver);
    }

    public AndroidElement getAddTaskBtn() {
        return addTaskBtn;
    }
}
