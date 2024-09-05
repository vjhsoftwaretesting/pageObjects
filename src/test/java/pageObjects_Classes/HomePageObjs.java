package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjs {
	@FindBy(id="createTitle")
	public static WebElement createButton;
	
	@FindBy(xpath="//*[@id='entries-home']/li[3]/a")
	public static WebElement manageMyEntriesButton;
	
	@FindBy(xpath="//*[@id='entries-home']/li[4]/a")
	public static WebElement manageTeamEntriesButton;
	
	@FindBy(xpath="//*[@id='billing-home']/li[2]/a")
	public static WebElement invoiceButton;
	

}
