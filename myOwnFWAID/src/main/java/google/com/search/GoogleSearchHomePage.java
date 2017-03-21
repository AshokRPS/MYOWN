package google.com.search;

import myOwnFWGID.myOwnFWAID.ActionHelper;

import org.openqa.selenium.WebDriver;

public class GoogleSearchHomePage {

	WebDriver driver;

	private String searchForTextBoxXpath = ".//*[contains(@id,'searchform')]//input[3][contains(@class,'gs')]";
	private String searchFormXpath = ".//*[contains(@id,'searchform')]//input[3][contains(@class,'gs')]";
	private String searchButtonXpath =".//input[contains(@value,'Google Search')]";

	public GoogleSearchHomePage(WebDriver driver) {
		this.driver = driver;

	}

	public void searchFor(String keyWord) {

		ActionHelper.waitForVisibilityOfEleByXpath(driver,
				searchFormXpath);
		ActionHelper.sendKeysToAnElementByXpath(driver, searchForTextBoxXpath,
				keyWord);
		ActionHelper.click(driver, searchButtonXpath);

	}

}
