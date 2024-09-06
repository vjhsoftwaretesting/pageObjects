package reusable_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects_Classes.LoginPageObjs;

public class LoginClass {
	WebDriver driver;

	public void loginScript(WebDriver driver) throws InterruptedException {
		this.driver = driver;

		// driver.get("https://oauth2qa.ebillity.com/web/session/new");
		driver.get("https://secure.ebillity.com/web/session/new");
		driver.manage().window().maximize();

		String email = "lock@mailinator.com";// "ebillitysage50feb14@mailinator.com"
		String pword = "Test123";
		// String expServer= "Server 8V";

		// while(!driver.getPageSource().contains(expServer)) {
		// driver.manage().deleteAllCookies();
		// driver.navigate().refresh();
		// System.out.println("not match");
		// }

		PageFactory.initElements(driver, LoginPageObjs.class);
		LoginPageObjs.userID.sendKeys(email);
		LoginPageObjs.password.sendKeys(pword);
		LoginPageObjs.submitButton.click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("(//button[text()='Close'])[2]")).click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
