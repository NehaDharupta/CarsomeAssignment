package PACKAGE1;

public interface Objects {
	
        String mainScreenlogo ="(//a[@class='logo mobile-logo'])[1]";
		String menu = "//span[@data-track='header-click-buy-car']";
		String carNameOption = "(//div[@data-track='header-click-brand' and text()[normalize-space()='Perodua']])[1]" ;
		String searchOption = "(//div[@class='v-select__slot'])[1]/input";
		String AXIACarSearchResults = "//div[@class='mod-card__title__variant-engine' and contains(text(),'AXIA')]";
		String optionRecommended ="//div[text()='Recommended']";
		String optionLowestPrice = "//div[text()[normalize-space()='Lowest Price']]";
		String price = "//div[@class='mod-card__price__total']/strong";
	
		
	}



