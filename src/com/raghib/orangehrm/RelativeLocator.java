package com.raghib.orangehrm;

//import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * REFERENCES:-
 * https://www.youtube.com/watch?v=er7gX8naE8I
 * https://www.youtube.com/watch?v=k2tHh3mYaJg&t=605s
 */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.raghib.selenium.BaseClass;
import com.raghib.selenium.WaitClass;

public class RelativeLocator extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";

	public static String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		WaitClass wc = new WaitClass();
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		wc.explicitWaitClick(driver, Duration.ofSeconds(30), username);
		username.sendKeys("Admin");		
				
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		wc.explicitWaitClick(driver, Duration.ofSeconds(30), password);
		password.sendKeys("admin123");
		
		driver.findElement(
				with(
						By.tagName("button")
					).below(password)
				).click();
		
		WebElement dropdownElement = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
		dropdownElement.click();
		
		WebElement changePasswordElement = driver.findElement(By.xpath("//a[text()='Change Password']"));
		
		WebElement logoutButton = driver.findElement(
				with(
						By.tagName("a")
					).below(changePasswordElement)
				);		
		logoutButton.click();

		BaseClass.quitDriver();
	}
}