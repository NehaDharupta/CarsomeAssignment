package PACKAGE1;

public class MAIN {
	private static Login login;
	private static TestCase testcase;
	private static String url = "https://www.carsome.my/";

	/* Main Method */

	public static void main(String[] args) throws Exception {
		try {
			// TODO Auto-generated method stub
			login = new Login();
			testcase=new TestCase();
			
			/* Initiate driver ,open browser and url */
			login.Login(url);
			
			/* Run the test case */
			/*TestCase 1*/
			testcase.verifyAvailability();
			
			/*TestCase2*/
			testcase.verifySorting();
			
			/*close the browser*/
			login.closeBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}

