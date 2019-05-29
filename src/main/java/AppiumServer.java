import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.URL;

public abstract class AppiumServer {
    private static AppiumDriverLocalService service;

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

    public URL getServiceUrl() {
        return service.getUrl();
    }
}
