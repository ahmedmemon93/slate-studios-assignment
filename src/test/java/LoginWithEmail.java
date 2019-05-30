import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.PageFactory;

public class LoginWithEmail extends BaseTest {

    public LoginWithEmail(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LoginWithEmail enterEmailId(String emailId) {
        AndroidElement emailIdInput = findElementById("com.todoist:id/email_exists_input");
        emailIdInput.sendKeys(emailId);
        return this;
    }

    public LoginWithEmail clickOnLoginWithEmailBtn() {
        findElementById("com.todoist:id/btn_continue_with_email").click();
        return this;
    }

    public LoginWithEmail enterPassword(String password) {
        findElementById("com.todoist:id/log_in_password").sendKeys(password);
        return this;
    }

    public MainTaskList clickOnLoginButton() {
        findElementById("com.todoist:id/btn_log_in").click();
//        waitUntilElementAppears(findElementById("android:id/navigationBarBackground"));
        waitUntilElementDisappears(findElementById("android:id/navigationBarBackground"));
        if (driver.findElementById("com.todoist:id/alertTitle").isDisplayed()) {
            findElementById("android:id/button2").click();
        }
        return new MainTaskList(driver);
    }

    public MainTaskList login(String emailId, String password){
        enterEmailId(emailId);
        clickOnLoginWithEmailBtn();
        enterPassword(password);
        clickOnLoginButton();
        return new MainTaskList(driver);
    }

}
