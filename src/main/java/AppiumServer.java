import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

/**
 * This class is to control the start and stop of the appium server.
 * If appium is correctly installed on the machine along with node.js then
 * there is no need to start appium server manually.
 */
public abstract class AppiumServer {
    private static AppiumDriverLocalService service;

    /**
     * This method will start the appium server
     */
    public void startServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        service.getUrl();
    }

    public void stopServer() {
        if (service != null) {
            service.start();
        }
    }

    /**
     * This method will return the appium server url
     * @return
     */
    public URL getServiceUrl() {
        return service.getUrl();
    }
}
