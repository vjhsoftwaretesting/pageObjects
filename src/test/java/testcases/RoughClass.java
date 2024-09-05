package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects_Classes.ClientPageObjs;
import pageObjects_Classes.HomePageObjs;
import pageObjects_Classes.InvoicePageObjs;
import pageObjects_Classes.LoginPageObjs;
import pageObjects_Classes.ProjectsPageObjs;

public class RoughClass {
	
	//client
		String fName = "client"; //1
		String lName = "0010"; //2
		//project
		String cliName = String.join(" ", fName,lName);
		String proName = "pro 010"; //3
		//activity
		String activity = "Review";  //4
		//Date
		String date="20/03/2019";  //5
		String fromTime = "10:20 AM";  //6
		String toTime = "11:40 AM";  //7
		String[] dat = date.split("/");
		String day = dat[0];
		String month = dat[1];
		String year = dat[2];
		int yy = Integer.parseInt(year);
		String descTime = cliName+proName+fromTime+toTime+"-TE created with Selenium";
		static String cpyDate;
		//expese
		String expType = "Copying";
		String cost = "500";
		String qty = "3";
		String mark = "3";
		String descExp = cliName+proName+expType+"-EE created with Selenium";
		
WebDriver driver;
	
	@BeforeTest
	public void noLogin() {
		driver = new ChromeDriver();
		driver.get("https://secure.ebillity.com/web/session/new");
		driver.manage().window().maximize();
		
		String email = "ebillitysage50feb14@mailinator.com";
		String pword = "Test123";
		//String expServer= "Server 8V";
		
		//while(!driver.getPageSource().contains(expServer)) {
			//driver.manage().deleteAllCookies();
			//driver.navigate().refresh();
			//System.out.println("not match");
		//}
		
		PageFactory.initElements(driver, LoginPageObjs.class);
		LoginPageObjs.userID.sendKeys(email);
		LoginPageObjs.password.sendKeys(pword);
		LoginPageObjs.submitButton.click();
	}
	
	@Test(enabled=true, priority=6)
	public void invoice() throws InterruptedException {
		System.out.println("given client name :- "+cliName);
		
		PageFactory.initElements(driver, ClientPageObjs.class);
		ClientPageObjs.clientModule.click();
		//All filter
		driver.findElement(By.xpath("//div[text()='All']")).click();
		//find button
		driver.findElement(By.id("find")).click();
		driver.findElement(By.id("clientName")).sendKeys(cliName);
		driver.findElement(By.id("grdMyEntries_Search")).click();
		Thread.sleep(2000);
		WebElement c1 = driver.findElement(By.xpath("//*[@id='tr_0']/following-sibling::tr/td/span[text()='"+cliName+"']"));
		System.out.println("Client page>All filter has :- "+c1.getText());
		
		//Active filter
		driver.findElement(By.xpath("//div[text()='Active']")).click();
		Thread.sleep(2000);
		WebElement c2 = driver.findElement(By.xpath("//*[@id='tr_0']/following-sibling::tr/td/span[text()='"+cliName+"']"));
		System.out.println("Client page>Active filter has :- "+c2.getText());
		
		//project module
		//add project modal client filter
		PageFactory.initElements(driver, ProjectsPageObjs.class);
		ProjectsPageObjs.projectModule.click();
		ProjectsPageObjs.addProject.click();
		ProjectsPageObjs.clientDD.click();
		ProjectsPageObjs.clientSearchField.sendKeys(cliName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-results']/ul/li[contains(text(),'"+cliName+"')]")));
		System.out.println("In add project modal client filter has:- "+driver.findElement(By.xpath("//*[@class='select2-results']/ul/li[contains(text(),'"+cliName+"')]")).getText());
		
		//
		
		
		//driver.findElement(by.)
	}
	
	
	
	
}
