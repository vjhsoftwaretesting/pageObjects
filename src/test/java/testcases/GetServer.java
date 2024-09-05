package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects_Classes.LoginPageObjs;

public class GetServer {
	WebDriver driver;
	
	@Test
	public void noLogin() {
		driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/web/session/new");
		driver.manage().window().maximize();
		//INPUTS
		String email = "lock@mailinator.com";//"29feb24@mailinator.com"//hanahjoy@mailinator.com
		String pword = "Test123";
		String expServer= "Server 9V";
		
		while(!driver.getPageSource().contains(expServer)) {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			System.out.println("not match");
		}
		PageFactory.initElements(driver, LoginPageObjs.class);
		LoginPageObjs.userID.sendKeys(email);
		LoginPageObjs.password.sendKeys(pword);
		LoginPageObjs.submitButton.click();
		System.out.println("got server");
	}
}
