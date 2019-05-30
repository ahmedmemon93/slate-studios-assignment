import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import jdk.nashorn.internal.ir.WhileNode;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class MainTaskList extends BaseTest {
    public MainTaskList(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SidePanel openLeftPanel() {
        findElementByXpath("//android.widget.ImageButton[@content-desc=\"Change the current view\"]")
                .click();
        Assert.assertTrue(findElementById("com.todoist:id/profile_view_avatar").isDisplayed(),"Profile Image on left panel is not visible");
        return new SidePanel(driver);
    }

    public AddTask clickOnAddTaskBtn() {
        findElementById("com.todoist:id/fab").click();
        Assert.assertTrue(findElementById("android:id/message").isDisplayed(), "Add task text inputbox is not present");
        Assert.assertTrue(findElementById("com.todoist:id/schedule").isDisplayed(), "while adding new task schedule option is not present");
        return new AddTask(driver);
    }

    public MobileElement getLastElement(){
        int listSize = driver.findElementById("android:id/list").findElementsByXPath(".//android.widget.TextView").size();
        return driver.findElementById("android:id/list").findElementsByXPath(".//android.widget.TextView").get(listSize-1);
    }

    public void verifyTaskIsPresentInList(String taskName){
        List<MobileElement> taskList =  driver.findElementById("android:id/list").findElementsByXPath(".//android.widget.TextView[contains(@text,'"+taskName+"')]");

       // MobileElement lastElementOfList = getLastElement();
        Scroller scroller = new Scroller();
        while (driver.findElementById("android:id/list").findElementsByXPath(".//android.widget.TextView[contains(@text,'"+taskName+"')]").size()==0){
            int beforeScroll = getLastElement().getCenter().y;
            scroller.scrollDown(driver);
            int afterScroll = getLastElement().getCenter().y;
            if (beforeScroll==afterScroll){
                System.out.println("reached at the end");
                break;
            }
        }

        //Assert.assertTrue(taskList>0,taskName+" Not found in the list");
    }


}
