import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithEmail extends BaseTest {

    @FindBy(id = "com.todoist:id/email_exists_input")
    private AndroidElement emailIdInput;
    @FindBy(id = "com.todoist:id/btn_continue_with_email")
    private AndroidElement loginWithEmailBtn;
    @FindBy(id = "com.todoist:id/log_in_password")
    private AndroidElement passwordField;
    @FindBy (id = "com.todoist:id/btn_log_in")
    private AndroidElement loginBtn;
    @FindBy (id = "android:id/button2")
    private AndroidElement alertBtn;
    public LoginWithEmail(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public LoginWithEmail enterEmailId(String emailId) {
        emailIdInput.sendKeys(emailId);
        return this;
    }

    public LoginWithEmail clickOnLoginWithEmailBtn() {
        loginWithEmailBtn.click();
        return this;
    }

    public LoginWithEmail enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainTaskList clickOnLoginButton() {
        loginBtn.click();
        waitUntilElementDisappears(driver.findElementById("android:id/progress"));
        if (driver.findElementById("com.todoist:id/alertTitle").isDisplayed()) {
            alertBtn.click();
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
