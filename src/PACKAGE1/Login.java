package PACKAGE1;

public class Login {
	
	/* This class consists of login methods */

	
		public static llAction llaction;

		public Login() {
			llaction = new llAction();
		}

		/* Method to initiate chrome browser and Login to the main url*/
		public void Login(String url) throws Exception {
			try {
				llaction.maximizeWindow();
				llaction.waitUntilProcessingCompletes();
				llaction.enterUrl(url);
				
				/*Verify Main Screen displayed */
				if(llaction.isElementDisplayed(Objects.mainScreenlogo))
				{
					System.out.println("User Navigated to Main Screen");
				}
				else {
					throw new Exception("Page Not found");
				}
				llaction.waitUntilProcessingCompletes();
			} catch (Exception e) {
				System.out.println("URL not found");
				e.printStackTrace();
				System.exit(1);
			}

		}
		
		/* Method to close the browser after executions*/
		public void closeBrowser() {
			try{
			llaction.close();
			System.out.println("All tests successfully completed , driver closed");
			}catch(Exception e) {
				
			}

		}
	}


