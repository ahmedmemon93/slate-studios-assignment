import io.appium.java_client.android.AndroidDriver;
import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddTask extends BaseTest{
    public AddTask(AndroidDriver driver){
        PageFactory.initElements(driver,this);
    }

    public AddTask enterTaskDetailMessage(String taskDetailMessage){
        findElementById("android:id/message").sendKeys(taskDetailMessage);
        return this;
    }
    public AddTask addScheduleDate(){
        findElementById("com.todoist:id/schedule").click();
        findElementById("com.todoist:id/scheduler").click();
        return this;
    }
    public AddTask addPriority(){
        findElementById("com.todoist:id/priority").click();
        return this;
    }

    public AddTask addPerson(){
        findElementById("com.todoist:id/responsible").click();
        return this;
    }
    public AddTask addProject(){
        findElementById("com.todoist:id/project").click();
        return this;
    }

    public MainTaskList clickOnAddButton(){
        findElementById("android:id/button1").click();
        findElementById("android:id/button1").click();
        Assert.assertTrue(findElementById("com.todoist:id/fab").isDisplayed(),"Add Task button not displayed after closing task creation");
        return new MainTaskList(driver);
    }

    public void addTask(){

    }
}
