package testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects_Classes.ClientPageObjs;
import pageObjects_Classes.HomePageObjs;
import pageObjects_Classes.InvoicePageObjs;
import pageObjects_Classes.LoginPageObjs;
import pageObjects_Classes.MTEWindowObjs;
import pageObjects_Classes.ManageMyEntriesPageObjs;
import pageObjects_Classes.ProjectsPage;


public class SmokeTestMain {
	//client
	String fName = "client"; //1
	String lName = "0006"; //2
	//project
	String cliName = String.join(" ", fName,lName);
	String proName = "pro 006"; //3
	//activity
	String activity = "Review";  //4
	//Date
	String date="20/03/2024";  //5
	String fromTime = "10:00 AM";  //6
	String toTime = "11:00 AM";  //7
	String[] dat = date.split("/");
	String day = dat[0];
	String month = dat[1];
	String year = dat[2];
	String desc = cliName+proName+fromTime+toTime+"-TE created with Selenium";
	static String cpyDate;
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
	
	@Test(enabled=true, priority=0)
	public void client() throws InterruptedException {	
		PageFactory.initElements(driver, ClientPageObjs.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		ClientPageObjs.clientModule.click();
		ClientPageObjs.AddClient.click();
		ClientPageObjs.firstName.sendKeys(fName);
		ClientPageObjs.lastName.sendKeys(lName);
		ClientPageObjs.saveCloseClient.click();
		String expBannerMsg = cliName+" saved successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageContent']")));
		String actBannerMsg = driver.findElement(By.xpath("//*[@id='messageContent']")).getText();
		System.out.println("Client: "+actBannerMsg);
		Assert.assertEquals(actBannerMsg, expBannerMsg);
	}
	
	@Test(enabled=true, priority=1)
	public void project(){
		PageFactory.initElements(driver, ProjectsPage.class);
		ProjectsPage.projectModule.click();
		ProjectsPage.addProject.click();
		ProjectsPage.clientDD.click();
		ProjectsPage.clientSearchField.sendKeys(cliName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-results']/ul/li[contains(text(),'"+cliName+"')]")));
		driver.findElement(By.xpath("//*[@class='select2-results']/ul/li[contains(text(),'"+cliName+"')]")).click();
		ProjectsPage.projectNameFiled.sendKeys(proName);
		ProjectsPage.saveCloseProject.click();
		String expBannerMsg = "Project saved successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageContent']")));
		String actBannerMsg = driver.findElement(By.xpath("//*[@id='messageContent']")).getText();
		System.out.println("Project: "+actBannerMsg);
		Assert.assertEquals(actBannerMsg, expBannerMsg);
	}
	
	@Test(enabled=true, priority=2)
	public void MTE() throws InterruptedException {
		
		PageFactory.initElements(driver, MTEWindowObjs.class);
		PageFactory.initElements(driver, HomePageObjs.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		HomePageObjs.manageMyEntriesButton.click();
		HomePageObjs.createButton.click();	
		String oldWindow =driver.getWindowHandle();
		MTEWindowObjs.timeEntryButton.click();
		Set<String> newWindow = driver.getWindowHandles();  
		  for (String newwindow : newWindow) { driver.switchTo().window(newwindow); } 
		wait.until(ExpectedConditions.visibilityOf(MTEWindowObjs.clientDD));
		MTEWindowObjs.clientDD.click();
		MTEWindowObjs.clientSearchBox.sendKeys(proName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-results']/li/div[contains(text(),'"+cliName+"')]")));
		driver.findElement(By.xpath("//*[@class='select2-results']/li/div[contains(text(),'"+cliName+"')]")).click();
		MTEWindowObjs.activityDD.click();
		MTEWindowObjs.activitySearchBox.sendKeys(activity+" ");
		Thread.sleep(500);
		MTEWindowObjs.activitySearchBox.sendKeys(Keys.BACK_SPACE);
		MTEWindowObjs.activitySearchBox.sendKeys(Keys.ENTER);
		MTEWindowObjs.descriptionBox.sendKeys(desc);     
		//Date
		MTEWindowObjs.datePicker.click();
		MTEWindowObjs.dateHeader.click();
		Thread.sleep(500);
		while(true) {
			String yearHeader = driver.findElement(By.xpath("//*[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]")).getText();
			int y = Integer.parseInt(yearHeader);
			int yy = Integer.parseInt(year);
			if (y==yy) {
				break;
			}				
			else if(y<yy) {
				driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::th")).click();
			}
			else if (y>yy) {
				driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::th/preceding-sibling::th")).click();
			}	
		}
		Thread.sleep(500);
		if(month.equals("01")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Jan')]")).click();}
		else if(month.equals("02")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Feb')]")).click();}
		else if(month.equals("03")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Mar')]")).click();}
		else if(month.equals("04")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Apr')]")).click();}
		else if(month.equals("05")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'May')]")).click();}
		else if(month.equals("06")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Jun')]")).click();}
		else if(month.equals("07")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Jul')]")).click();}
		else if(month.equals("08")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Aug')]")).click();}
		else if(month.equals("09")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Sep')]")).click();}
		else if(month.equals("10")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Oct')]")).click();}
		else if(month.equals("11")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Nov')]")).click();}
		else if(month.equals("12")) {driver.findElement(By.xpath("//*[@class='datepicker-months'][@style='display: block;']/descendant::th[@class='switch'][not(contains(text(),'-'))][not(contains(text(),' '))]/following::span[contains(text(),'Dec')]")).click();}
			
		driver.findElement(By.xpath("//*[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block; top:')]/div[1]/table/tbody/tr/td[not(contains(@class,'day old'))][contains(text(),'"+day+"')]")).click();
		cpyDate = driver.findElement(By.xpath("//*[@class='pull-right tw_date']")).getText();
		MTEWindowObjs.timeIN.clear();
		MTEWindowObjs.timeIN.sendKeys(fromTime);
		MTEWindowObjs.timeOUT.sendKeys(toTime);
		MTEWindowObjs.saveButton.click();
		Thread.sleep(2000);
		driver.switchTo().window(oldWindow);
	}
	
	@Test(enabled=true, priority=3)
	public void manageMyEntries() throws InterruptedException {
		PageFactory.initElements(driver, ManageMyEntriesPageObjs.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		ManageMyEntriesPageObjs.fingButton.click();
		Thread.sleep(1000);
		ManageMyEntriesPageObjs.clientFilter.click();
		ManageMyEntriesPageObjs.searchField.sendKeys(cliName);
		Thread.sleep(800);
		ManageMyEntriesPageObjs.cliSearchResult.click();
		ManageMyEntriesPageObjs.projectFilter.click();
		ManageMyEntriesPageObjs.searchField.sendKeys(proName);
		Thread.sleep(800);
		ManageMyEntriesPageObjs.proSearchResult.click();
		ManageMyEntriesPageObjs.activityFilter.click();
		ManageMyEntriesPageObjs.searchField.sendKeys(activity);
		Thread.sleep(800);
		ManageMyEntriesPageObjs.actSearchResult.click();
		ManageMyEntriesPageObjs.fromDateFilter.clear();
		ManageMyEntriesPageObjs.fromDateFilter.sendKeys(cpyDate);
		Thread.sleep(800);
		ManageMyEntriesPageObjs.toDateFilter.clear();
		ManageMyEntriesPageObjs.toDateFilter.sendKeys(cpyDate);
		Thread.sleep(800);
		ManageMyEntriesPageObjs.searchFilterButton.click();
		Thread.sleep(800);
		//entry checkbox
		driver.findElement(By.xpath("//*[@id='tr_0']/following::td/span[contains(text(),'"+cpyDate+"')]/following::td/span[contains(text(),'"+desc+"')]/parent::td/preceding-sibling::td/input")).click();
		ManageMyEntriesPageObjs.submitButton.click();
		ManageMyEntriesPageObjs.submittedFilter.click();
		Thread.sleep(1000);		
		//entry inline arrow
		driver.findElement(By.xpath("//*[@id='tr_0']/following::td/span[contains(text(),'"+cpyDate+"')]/following::td/span[contains(text(),'"+desc+"')]/parent::td/following-sibling::td[5]")).click();
		ManageMyEntriesPageObjs.inlineApproveButton.click();
		String expBannerMsg = "Approved Successfully";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageContent'][contains(text(),'Approved Successfully')]")));
		String actBannerMsg = driver.findElement(By.xpath("//*[@id='messageContent']")).getText();
		System.out.println("Time Entry: "+actBannerMsg);
		Assert.assertEquals(actBannerMsg, expBannerMsg);
	}
	
	@Test(enabled=true, priority=4)
	public void invoice() throws InterruptedException {
		PageFactory.initElements(driver, HomePageObjs.class);
		PageFactory.initElements(driver, InvoicePageObjs.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		HomePageObjs.invoiceButton.click();
		InvoicePageObjs.addInvoiceButton.click();
		InvoicePageObjs.invoiceClientDD.click();
		InvoicePageObjs.cliSearchField.sendKeys(cliName);
		//select client
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='select2-results']/li/div[contains(text(),'"+cliName+"')]")));
		driver.findElement(By.xpath("//*[@class='select2-results']/li/div[contains(text(),'"+cliName+"')]")).click();
		//select project
		wait.until(ExpectedConditions.visibilityOf(InvoicePageObjs.invoiceFromDate));
		InvoicePageObjs.invoiceToDate.clear();
		InvoicePageObjs.invoiceFromDate.clear();
		InvoicePageObjs.invoiceFromDate.sendKeys(cpyDate);
		InvoicePageObjs.invoiceToDate.sendKeys(cpyDate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='LazyListBox']/option[contains(text(),'"+proName+"')]")));
		driver.findElement(By.xpath("//*[@id='LazyListBox']/option[contains(text(),'"+proName+"')]")).click();
		InvoicePageObjs.searchButton.click();
		Thread.sleep(5000);
		InvoicePageObjs.dateCheckbox.click();
		if(InvoicePageObjs.dateCheckbox.isSelected()) {
			InvoicePageObjs.dateCheckbox.click();
		}
		else {}
		String fourtyChars="";
		if(desc.length()>4) {
			fourtyChars=desc.substring(0,39);
		}
		else {
			fourtyChars=desc;
		}
		driver.findElement(By.xpath("//*[@align='left'][contains(text(),'Time')]/following::span[contains(text(),'"+activity+"')]/following::span[contains(text(),'"+fourtyChars+"')]/parent::span/parent::div/parent::td/preceding-sibling::td/span/input")).click();
		InvoicePageObjs.savePreBill.click();
	}
		

}