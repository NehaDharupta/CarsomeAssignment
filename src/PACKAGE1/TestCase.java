package PACKAGE1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

public class TestCase {
	
	public static llAction llaction;
	
	public TestCase() {

		llaction = new llAction();
		
	}

	
	/*Test Case 01 - Verify Perodua AIXA is available in carsome*/
	
	public void verifyAvailability() throws Exception {
		try {
			llaction.click(Objects.menu);
			llaction.waitUntilProcessingCompletes();
			
			llaction.click(Objects.carNameOption);
			
			
			llaction.click(Objects.searchOption);
			llaction.enterText(Objects.searchOption, "AXIA");
			llaction.cickEnter(Objects.searchOption);
			
			
			llaction.refreshBrowser();
			
			/* List all the Perodua AIXA cars displayed in the webpage*/
			List elements = llaction.listWebElements(Objects.AXIACarSearchResults);
			int size= elements.size();
			if (size==18)
				
			{
				System.out.println("18 Perodua AIXA cars displayed in carsome");
			}
			else
			{
				System.out.println("18 Perodua AIXA cars not displayed instead " +size+ "number of cars displayed");
				}
		
			
			}catch (Exception e) {
				System.out.println("Exception found");
				e.printStackTrace();
				System.exit(1);
			}
	}
	
	/*Test Case 02 - Verify the price of available Perodua AXIA is can be sorted from lowest to highest*/
	
		public void verifySorting() throws Exception {
			try {
				llaction.click(Objects.optionRecommended);
				
				llaction.click(Objects.optionLowestPrice);
				llaction.sleep(10);
				
				/* List all the prices for Perodua AIXA cars displayed in the webpage*/
				List <WebElement> elements = llaction.listWebElements(Objects.price);
				
				List<String> prices= new ArrayList<String>();
				for(WebElement e :elements)
				{
					prices.add(e.getText().trim().replaceAll(",", ""));
				}
				
				/* Make a copy of the list*/
				List<String> sortedPrice = new ArrayList<String>(prices);
				/* Sort this list in Ascending order */
				Collections.sort(sortedPrice);
				
				if (sortedPrice.equals(prices))
				{
					System.out.println("The prices on webpage are correctly displayed in ascending order");
				}
				else {
					System.out.println("The prices on webpage are incorrectly displayed i.e. are not in ascending order");;
				}
				
			}catch (Exception e) {
				System.out.println("Exception found");
				e.printStackTrace();
				System.exit(1);
			}
			}



}
