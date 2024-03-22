package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjs {

	@FindBy(id="txtEmail")
	public static WebElement userID;
	
	@FindBy(id="txtPassword")
	public static WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	public static WebElement submitButton;

	}

