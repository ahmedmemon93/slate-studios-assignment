import org.testng.annotations.Test;

import java.io.IOException;

public class APITesst extends BaseTest {

    @Test
    public void aPITestt() throws IOException {
//        ApiController apiController = new ApiController("https://en.todoist.com");
//        Map<String, String> loginRequestParam = new HashMap<String, String>();
//        Map<String, String> headerMap = new HashMap<String, String>();
//        loginRequestParam.put("csrf", apiController.getCsrf());
//        loginRequestParam.put("email",prop.getEmailId());
//        loginRequestParam.put("password",prop.getPassword());
//        apiController.postRequest("https://en.todoist.com/Users/greyboxCloseLogin?mini=",loginRequestParam,headerMap);

        ProjectApi projectApi = new ProjectApi();
        projectApi.createProject("TestProject");
    }
}
