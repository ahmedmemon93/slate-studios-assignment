import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to load the properties files from config.properties  and store into variable.
 * There is no other logic in this class, just read properties files from resource folder and assign
 * the values to the respective variables.
 */

public class PropertiesLoader {
    private Properties prop;
    private String deviceName;
    private String udId;
    private String platformName;
    private String platformVersion;
    private String appPackage;
    private String appActivity;
    private String appiumServerUrl;
    private String apkFileName;
    private String emailId;
    private String password;

    public PropertiesLoader() {
        prop = new Properties();
        loadProperties();
    }

    /**
     * The constructor will do the job of assigning properties values to variables.
     */
    private void loadProperties() {
        InputStream fileInput = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        deviceName = prop.getProperty("deviceName");
        udId = prop.getProperty("udid");
        platformName = prop.getProperty("platformName");
        platformVersion = prop.getProperty("platformVersion");
        appPackage = prop.getProperty("appPackage");
        appActivity = prop.getProperty("appActivity");
        appiumServerUrl = prop.getProperty("appiumServerURL");
        apkFileName = prop.getProperty("apkFileName");
        emailId = prop.getProperty("emailId");
        password = prop.getProperty("password");
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getUdId() {
        return udId;
    }

    public void setUdId(String udId) {
        this.udId = udId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getAppiumServerUrl() {
        return appiumServerUrl;
    }

    public void setAppiumServerUrl(String appiumServerUrl) {
        this.appiumServerUrl = appiumServerUrl;
    }

    public String getApkFileName() {
        return apkFileName;
    }

    public void setApkFileName(String apkFileName) {
        this.apkFileName = apkFileName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
