package PACKAGE1;
	import java.util.List;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class llAction extends InitiateDriver {
		
		/* This class consists of all the methods that will be used across the framework to perform operations on Browser or Objects */

		/* Global Variables */
		public static Alert alert;
		public static Actions action;

		/* Method to enter Text values */
		public void enterText(String xpath, String textToEnter) throws Exception {
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
				if (element.isDisplayed()) {
					element.clear();
					element.sendKeys(textToEnter);
				}
			} catch (Exception e) {
				System.out.println("Element not found or Text not able to enter");
				e.printStackTrace();
				System.exit(1);
			}

		}
		
		/* Method to get Text values */
		public String getText(String xpath ) throws Exception {
			String value = "";
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
				if (element.isDisplayed()) {
					value= element.getText();
				}
			} catch (Exception e) {
				System.out.println("Element not found");
				e.printStackTrace();
				System.exit(1);
			}
			return value;

		}
		
		
		/* Click enter Key */
		public void cickEnter(String xpath) throws Exception {
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
					element.sendKeys(Keys.ENTER);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}

		}

		/* Method to click on button */
		public void click(String xpath) throws Exception {
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
				if (element.isDisplayed()) {
					element.click();
				}
			} catch (Exception e) {
				System.out.println("Element not found or not able to click");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Method to select a value from dropdown */
		public void selectByVisibleText(String xpath, String value) throws Exception {
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
				if (element.isDisplayed()) {
					Select s = new Select(element);
					s.selectByVisibleText(value);
				}
			} catch (Exception e) {
				System.out.println("Element not found or not able to select");
				e.printStackTrace();
				System.exit(1);
			}

		}

		/* Accept Alert */
		public void acceptAlert() throws Exception {
			try {
				alert = getdriver().switchTo().alert();
				alert.accept();
			} catch (Exception e) {
				System.out.println("Element not found or not able to accept Alert");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Dismiss Alert */
		public void dismissAlert() throws Exception {
			try {
				alert = getdriver().switchTo().alert();
				alert.dismiss();
			} catch (Exception e) {
				System.out.println("Element not found or not able to dismiss Alert");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Enter Text in Alert */
		public void enterTextToAlert(String value) throws Exception {
			try {
				alert = getdriver().switchTo().alert();
				alert.sendKeys(value);
			} catch (Exception e) {
				System.out.println("Element not found or not able to enter text to Alert");
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		/* Verify element displayed */
		public boolean isElementDisplayed(String xpath) throws Exception {
			boolean value = false;
			try {
				WebElement element = getdriver().findElement(By.xpath(xpath));
				if (element.isDisplayed()) {
					value= true;
				}
				
			} catch (Exception e) {
				System.out.println("Element not found");
				e.printStackTrace();
				System.exit(1);
			}
			return value;
		}

		/* Hover */
		public void hover(String xpath) throws Exception {
			try {
				action = new Actions(getdriver());
				WebElement element = getdriver().findElement(By.xpath(xpath));
				action.moveToElement(element).perform();

			} catch (Exception e) {
				System.out.println("Element not found or not able to hover");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* List Web Elements */
		public List<WebElement> listWebElements(String xpath)throws Exception {
			List<WebElement> element = getdriver().findElements(By.xpath(xpath));
			return element;
		}

		/* Implicit wait till condition met */
		public void waitUntilProcessingCompletes() throws Exception {
			try {
				WebDriverWait wait = new WebDriverWait(getdriver(), 60);
				ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
								.equals("complete");
					}
				};
				wait.until(pageLoadCondition);
				// getdriver().manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* enter URL */
		public void enterUrl(String url) throws Exception{
			try {
				getdriver().get(url);
			} catch (Exception e) {
				System.out.println("Not able to enter url");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Navigate to URL */
		public void navigateTo(String url) throws Exception{
			try {
				getdriver().navigate().to(url);
			} catch (Exception e) {
				System.out.println("Not able to navigate to url");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* maximize window */
		public void maximizeWindow() throws Exception{
			try {
				getdriver().manage().window().maximize();
			} catch (Exception e) {
				System.out.println("Not able to maximize window");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Refresh Browser */
		public void refreshBrowser() throws Exception{
			try {
				getdriver().navigate().refresh();
			} catch (Exception e) {
				System.out.println("Not able to Refresh Browser");
				e.printStackTrace();
				System.exit(1);
			}
		}

		/* Construct XPath */
		public String editXpath(String actualXpath, String optionalXpath) throws Exception{
			String Xpath[] = actualXpath.split("##");
			String finalXpath = Xpath[0] + optionalXpath + Xpath[1];
			return finalXpath;

		}
		
		/* Wait */
		public static void sleep(int seconds)
		{
			try {
				Thread.sleep(1000*seconds);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			
		/* Close browser */
	public void close() throws Exception{
		try {
			getdriver().close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	}



