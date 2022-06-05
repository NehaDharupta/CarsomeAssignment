package PACKAGE1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriver {
	/* This class is to initiate the driver */

	
		public static WebDriver driver;

		public InitiateDriver() {
		}

		public static WebDriver getdriver() throws Exception {
			try {
				if (driver == null) {
					String path = System.getProperty("user.dir") + "\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver", path);
					driver = new ChromeDriver();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			return driver;
		}
	}



