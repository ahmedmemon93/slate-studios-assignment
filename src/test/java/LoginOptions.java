import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOptions extends BaseTest {

    public LoginOptions (AndroidDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickLoginWithGoogle(){

    }

    public void clickLoginWithFaceBook(){

    }

    public LoginWithEmail clickLoginWithEmail(){
        AndroidElement loginWithEmail = findElementById("com.todoist:id/btn_welcome_continue_with_email");
        loginWithEmail.click();
        return new LoginWithEmail(driver);
    }

}
