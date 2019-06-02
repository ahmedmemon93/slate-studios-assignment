package api;

import org.testng.Assert;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class ApiController {
    private String csrf;
    private String baseUrl;
    private HttpURLConnection con;
    private URL url = null;

    public ApiController(String baseUrl) {
        this.baseUrl = baseUrl;
        try {
            url = new URL(this.baseUrl);
            this.con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            Assert.assertEquals(responseCode, 200, baseUrl + " The url is not working");
            csrf = extractCsrf(con.getHeaderFields().get("Set-Cookie").get(0));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String email, String password) {
        Map<String, String> loginRequestParam = new HashMap<String, String>();
        Map<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("content-type", "application/x-www-form-urlencoded");
        headerMap.put("cookie", "csrf=" + getCsrf());
        headerMap.put("origin", "https://en.todoist.com");
        headerMap.put("referer", "https://en.todoist.com/?mini=1");
        loginRequestParam.put("csrf", getCsrf());
        loginRequestParam.put("email", email);
        loginRequestParam.put("password", password);
        try {
            postRequest("https://en.todoist.com/Users/login", loginRequestParam, headerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cookie = con.getHeaderFields().get("Set-Cookie").get(0);

    }

    public void postRequest(String url, Map paramters, Map headerMap, String... data) throws IOException {
        String payLoadData = "";
        if (data.length > 0) {
            payLoadData = data[0];
        }
        this.url = new URL(url);
        this.con = (HttpURLConnection) this.url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Cookie", "csrf=" + getCsrf());
        setHeaders(headerMap);
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(paramters));
        if (data.length > 0) {
            payLoadData = data[0];
            this.sendData(con, payLoadData);
        }
        out.flush();
        out.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        Assert.assertEquals(con.getResponseCode(), 200, url + " not successful");
        int responseCode = con.getResponseCode();
    }

    public void setHeaders(Map<String, String> headerMap) {
        for (String key : headerMap.keySet()) {
            con.setRequestProperty(key, headerMap.get(key));
        }
    }

    public String extractCsrf(String cookie) {
        String pattern = "csrf=([0-9a-z]{32})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(cookie);
        if (m.find()) {
            return m.group(1);
        } else return null;
    }

    protected void sendData(HttpURLConnection con, String data) throws IOException {
        DataOutputStream wr = null;
        try {
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(data);
            wr.flush();
            wr.close();
        } catch (IOException exception) {
            throw exception;
        }
    }

    public String getCsrf() {
        return csrf;
    }
}

class ParameterStringBuilder {
    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }


}
