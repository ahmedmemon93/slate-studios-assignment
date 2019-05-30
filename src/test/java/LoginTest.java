import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginToToDo() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions.clickLoginWithEmail()
                .enterEmailId(prop.getEmailId())
                .clickOnLoginWithEmailBtn()
                .enterPassword(prop.getPassword())
                .clickOnLoginButton();
    }

    @Test
    public void createProject() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions.clickLoginWithEmail()
                .enterEmailId(prop.getEmailId())
                .clickOnLoginWithEmailBtn()
                .enterPassword(prop.getPassword())
                .clickOnLoginButton()
                .openLeftPanel()
                .expandProject()
                .verifyProjectByName("Javed");
    }

    @Test
    public void createTask(){
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions
                .clickLoginWithEmail()
                .login(prop.getEmailId(),prop.getPassword())
//                .openLeftPanel()
//                .openProjectByName("Javed")
//                .clickOnAddTaskBtn()
//                .enterTaskDetailMessage("This is test task")
//                .addScheduleDate()
//                .addPriority()
//                .addPerson()
//                .addProject()
//                .clickOnAddButton()
                .verifyTaskIsPresentInList("This is test task");
    }

}
