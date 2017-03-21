/**
 * 
 */
package myOwnFWGID.myOwnFWAID;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;

/**
 * @author 582450
 *
 */
public abstract class ActionHelper {
	
	
	public static void waitForVisibilityOfEleByXpath(final WebDriver driver,
			String elementXpath) {
		FluentWait<By> fluentWait = new FluentWait<By>(By.xpath(elementXpath));
		fluentWait.pollingEvery(10, TimeUnit.MILLISECONDS);
		fluentWait.withTimeout(15, TimeUnit.SECONDS);
		fluentWait.until(new Predicate<By>() {
			public boolean apply(final By by) {
				try {

					return driver.findElement(by).isDisplayed();
				} catch (Exception ex) {

					return false;
				}
			}
		});

	}
	
	public static void sendKeysToAnElementByXpath(final WebDriver driver,
			final String eleXpath, final String fieldValue) {
		try {
			driver.findElement(By.xpath(eleXpath)).clear();
			driver.findElement(By.xpath(eleXpath)).sendKeys(fieldValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void click(final WebDriver driver, final String eleXpath) {
		try {
			driver.findElement(By.xpath(eleXpath)).click();

		} catch (Exception e) {

		}
	}

}
