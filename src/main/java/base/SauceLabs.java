package base;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs extends Driver {
	DesiredCapabilities caps;

	public void setSaucelabs() {
		String userName = getSaucelabsProperty("userName");
		String accessKey = getSaucelabsProperty("accessKey");
		String url = "https://" + userName + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub";
		try {
			setCapabilities();
			driver = new RemoteWebDriver(new URL(url), caps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.get(getProperty("appUrl"));
	}

	public void setCapabilities() {
		String browser = getSaucelabsProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("fireFox")) {
			caps = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else {
			caps = DesiredCapabilities.firefox();
		}
		caps.setCapability("platform", getSaucelabsProperty("platform"));
		caps.setCapability("version", getSaucelabsProperty("browserVersion"));

	}
}
