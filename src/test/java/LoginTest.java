import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

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
                .openLeftPanel()
                .openProjectByName("Javed")
                .clickOnAddTaskBtn()
                .enterTaskDetailMessage("This is test task")
                .addScheduleDate()
                .addPriority()
                .addPerson()
                .addProject()
                .clickOnAddButton()
                .verifyTaskIsPresentInList("This is test task");
    }

    @Test
    public void reOpenTask(){
        try {
            LoginOptions loginOptions = new LoginOptions(driver);
            loginOptions
                    .clickLoginWithEmail()
                    .login(prop.getEmailId(), prop.getPassword())
                    .openLeftPanel()
                    .openProjectByName("Javed")
                    .clickOnAddTaskBtn()
                    .enterTaskDetailMessage("This is test task")
                    .addScheduleDate()
                    .clickOnAddButton()
                    .clickOnTaskByName("This is test task")
                    .completeTask()
                    .goToCompleteTask()
                    .selectTaskByName()
                    .clickOnUncompleteTaskBtn();
        }
        catch (Exception e){
            e.printStackTrace();
            File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(file, new File("Screenshot.jpg"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
