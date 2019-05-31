import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedTaskList extends BaseTest {
    @FindBy(id = "com.todoist:id/menu_item_uncomplete")
    AndroidElement unCompleteTaskBtn;
    public CompletedTaskList(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public CompletedTaskList selectTaskByName(){
        findElementByXpath("//android.widget.LinearLayout//android.widget.TextView[ contains(@text,'" + "This is test" + "')]").click();
        return this;
    }
    public CompletedTaskList clickOnUncompleteTaskBtn(){
        unCompleteTaskBtn.click();
        return this;
    }
}
