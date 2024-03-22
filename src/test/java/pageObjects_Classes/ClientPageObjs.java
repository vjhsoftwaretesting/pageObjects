package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPageObjs {
	
	@FindBy(id="mnu_client-home")
	public static WebElement clientModule;
	
	@FindBy(id="addClient")
	public static WebElement AddClient;
	
	@FindBy(id="txtFirstName")
	public static WebElement firstName;
	
	@FindBy(id="txtLastName")
	public static WebElement lastName;
	
	@FindBy(id="save_CloseClient")
	public static WebElement saveCloseClient;
	
}
