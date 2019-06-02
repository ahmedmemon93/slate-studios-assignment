import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginOptions extends BaseTest {
    /**
     * This class is the first screen which has multiple login option,
     * user can select different options to login.
     */
    @AndroidFindBy(id = "com.todoist:id/btn_welcome_continue_with_email")
    private AndroidElement loginWithEmail;
    public LoginOptions (AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickLoginWithGoogle(){
        // you can implement the method if you want to login using Google
    }

    public void clickLoginWithFaceBook(){
        // you can implement the mehtod if you want to login using facebook
    }

    /**
     * This method will help user to login via email. and Will redirect to password screen
     * @return
     */

    public LoginWithEmail clickLoginWithEmail(){
        loginWithEmail.click();
        return new LoginWithEmail(driver);
    }

}
