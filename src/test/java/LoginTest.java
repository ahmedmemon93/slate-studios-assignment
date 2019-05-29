import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginToToDo() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions.clickLoginWithEmail()
                .EnterEmailId(prop.getEmailId())
                .clickOnLoginWithEmailBtn()
                .enterPassword(prop.getPassword())
                .clickOnLoginButton();
    }

    @Test
    public void createProject() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions.clickLoginWithEmail()
                .EnterEmailId(prop.getEmailId())
                .clickOnLoginWithEmailBtn()
                .enterPassword(prop.getPassword())
                .clickOnLoginButton()
                .openLeftPanel()
                .expandProject()
                .verifyProjectByName("Javed");
    }

}
