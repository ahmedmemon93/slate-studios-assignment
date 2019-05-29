import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.PageFactory;

public class LoginWithEmail extends BaseTest {

   public LoginWithEmail(AndroidDriver driver){
        PageFactory.initElements(driver,this);
    }
    public LoginWithEmail EnterEmailId(String emailId){
        AndroidElement emailIdInput = findElementById("com.todoist:id/email_exists_input");
        emailIdInput.sendKeys(emailId);
        return this;
    }

    public LoginWithEmail clickOnLoginWithEmailBtn(){
        findElementById("com.todoist:id/btn_continue_with_email").click();
        return this;
    }

    public LoginWithEmail enterPassword(String password){
       findElementById("com.todoist:id/log_in_password").sendKeys(password);
       return this;
    }

    public void clickOnLoginButton(){
       findElementById("com.todoist:id/btn_log_in").click();
    }

}
