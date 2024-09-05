package testcases;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects_Classes.LoginPageObjs;

public class Get_AllServers {

	WebDriver driver;

	@DataProvider(name = "server_numbers")
	public String[] provider() {
		String[] numbers = {"6","7","8","9","10","11","13"};
		return numbers;
	}
	ArrayList<String> sLogin = new ArrayList<String>();

	@Test(dataProvider = "server_numbers", timeOut = 60000)
	public void noLogin(String numbers) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/web/session/new");
		driver.manage().window().maximize();
		// INPUTS
		String email = "larajoy@mailinator.com";
		String pword = "Test123";
		String expServer = "Server " + numbers + "V";
		
		PageFactory.initElements(driver, LoginPageObjs.class);
		LoginPageObjs.userID.sendKeys(email);
		LoginPageObjs.password.sendKeys(pword);
		LoginPageObjs.submitButton.click();
		Thread.sleep(2000);
		String a = driver.findElement(By.xpath("//*[@class='noHover']/descendant::span[2]")).getText();
		System.out.println("got server" + a);
		sLogin.add(a);

		while (!a.equals(expServer)) {
			if(!a.contains((CharSequence) sLogin))
				break;
			
		driver.findElement(By.id("signout")).click();
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		System.out.println("not match");
		}
		
	}
	
	@Test 
	public void we() {
		System.out.println(sLogin);
	}

}
