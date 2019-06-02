import org.testng.annotations.Test;

/**
 * This is test class and all the given 3 test cass will start from here.
 * If you want to add any new test case you can add here or create new similar class.
 */

public class AssignmentTestCases extends BaseTest {
    String testTaskName = "TestTask_" + getDateTime();

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
    public void createTask() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions
                .clickLoginWithEmail()
                .login(prop.getEmailId(), prop.getPassword())
                .openLeftPanel()
                .openProjectByName(testTaskName)
                .clickOnAddTaskBtn()
                .enterTaskDetailMessage(testTaskName)
                .addScheduleDate()
                .addPriority()
                .addPerson()
                .addProject()
                .clickOnAddButton()
                .verifyTaskIsPresentInList(testTaskName);
    }

    @Test
    public void reOpenTask() {
        LoginOptions loginOptions = new LoginOptions(driver);
        loginOptions
                .clickLoginWithEmail()
                .login(prop.getEmailId(), prop.getPassword())
                .openLeftPanel()
                .openProjectByName("Javed")
                .clickOnAddTaskBtn()
                .enterTaskDetailMessage(testTaskName)
                .addScheduleDate()
                .clickOnAddButton()
                .clickOnTaskByName(testTaskName)
                .completeTask()
                .goToCompleteTask()
                .selectTaskByName(testTaskName)
                .clickOnUncompleteTaskBtn()
                .clickOnBackBtn()
                .clickOnTaskByName(testTaskName);// this will verify that whether the task is moved to list or not
    }

}
