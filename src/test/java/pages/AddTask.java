package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * This class will handle all the actions related to adding a task,
 * Once user clicks on + to add the task this class will be called.
 */
public class AddTask extends BaseTest {
    @FindBy(id = "android:id/message")
    private AndroidElement taskMessageInput;
    @FindBy(id = "com.todoist:id/schedule")
    private AndroidElement addSchedule;
    @FindBy(id = "com.todoist:id/priorit")
    private AndroidElement priority;
    @FindBy(id = "com.todoist:id/responsible")
    private AndroidElement addUser;
    @FindBy(id = "com.todoist:id/project")
    private AndroidElement addProject;
    @FindBy(id = "android:id/button1")
    private AndroidElement addTaskArrowBtn;
    @FindBy (id = "com.todoist:id/scheduler_predict")
    private AndroidElement predictDate;

    public AddTask(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public AddTask enterTaskDetailMessage(String taskDetailMessage) {
        taskMessageInput.sendKeys(taskDetailMessage);
        return this;
    }

    public AddTask addScheduleDate() {
        addSchedule.click();
        waitForElement(predictDate).click();
        return this;
    }

    public AddTask addPriority() {
        priority.click();
        return this;
    }

    public AddTask addPerson() {
        addUser.click();
        return this;
    }

    public AddTask addProject() {
        addProject.click();
        return this;
    }

    public MainTaskList clickOnAddButton() {
        addTaskArrowBtn.click();
        addTaskArrowBtn.click(); // second click will close the add task UI
        Assert.assertTrue(new MainTaskList(BaseTest.driver).getAddTaskBtn().isDisplayed(), "Add Task button not displayed after closing task creation");
        return new MainTaskList(BaseTest.driver);
    }
}
