import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOptions extends BaseTest {

    @AndroidFindBy(id = "com.todoist:id/btn_welcome_continue_with_email")
    private AndroidElement loginWithEmail;
    public LoginOptions (AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickLoginWithGoogle(){

    }

    public void clickLoginWithFaceBook(){

    }

    public LoginWithEmail clickLoginWithEmail(){
        loginWithEmail.click();
        return new LoginWithEmail(driver);
    }

}
