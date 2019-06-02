import api.ApiController;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ProjectApi extends BaseTest {
    ApiController apiController;
    private String createProjectUrl = "https://en.todoist.com/API/v8.1/sync";

    public ProjectApi() {
        apiController = new ApiController("https://en.todoist.com");
        apiController.login(prop.getEmailId(), prop.getPassword());
    }

    public void createProject(String projectName) {
        Map<String, String> createProjectParam = new HashMap<String, String>();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Origin", "https://en.todoist.com");
        headerMap.put("Referer", "https://en.todoist.com/app?r=1559488504399");
        headerMap.put("X-CSRFToken", "1559488504399");
        try {
            apiController.postRequest(createProjectUrl, createProjectParam, headerMap, sycApiData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sycApiData() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\"resource_types\":[\"all\"],");
        stringBuffer.append("\"commands\":[],\"day_orders_timestamp\":\"\",");
        stringBuffer.append("\"collaborators_timestamp\":\"\",");
        stringBuffer.append("\"sync_token\":\"*\",\"with_web_static_version\":true,");
        stringBuffer.append("\"limit_notes\":1,\"max_notes\":5,\"with_dateist_version\":1}");
        return stringBuffer.toString();
    }
}
