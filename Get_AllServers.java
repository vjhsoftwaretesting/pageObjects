package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects_Classes.LoginPageObjs;

public class Get_AllServers {
	
WebDriver driver;
	
	@DataProvider(name="server_numbers")
	public String[] provider() {
		String[] numbers = {"6","7","8","9","10","11","13"};
		return numbers;
	}
	
	@Test(dataProvider = "server_numbers",timeOut=180000)
	public void noLogin(String numbers) {
		driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/web/session/new");
		driver.manage().window().maximize();
		//INPUTS
		String email = "andttb01@mailinator.com";
		String pword = "Test123";
		String expServer= "Server "+numbers+"V";
		
		while(!driver.getPageSource().contains(expServer)) {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			System.out.println("not match");
		}
		PageFactory.initElements(driver, LoginPageObjs.class);
		LoginPageObjs.userID.sendKeys(email);
		LoginPageObjs.password.sendKeys(pword);
		LoginPageObjs.submitButton.click();
		System.out.println("got server"+numbers);
	}

}
