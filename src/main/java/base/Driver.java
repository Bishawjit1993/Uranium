package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {
	public static WebDriver driver;

	public void setDriver() {
		String browser = getProperty("browser");
		if (browser.equalsIgnoreCase("frieFox")) {
			initFirefox();
		} else {
			initFirefox();
		}
		setDriverProperties();
		driver.get(getProperty("appUrl"));
	}

	private void initFirefox() {
		driver = new FirefoxDriver();
	}

	private void setDriverProperties() {
		driver.manage().window().maximize();
	}

}
