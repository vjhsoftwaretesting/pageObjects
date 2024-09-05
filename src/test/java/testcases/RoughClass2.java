package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RoughClass2 {
	WebDriver driver;	
	//dynamic inputs
	String InsName = "Sikkan Hospital_11";
	String SHName = "SKK11";
	String Insmail = "sikkan11@mailinator.com";
	String timeZo = "Abu Dhabi";
	String[]splitted=timeZo.split(" ");
	String timeZone = splitted[0];
	String noOfHcPro = "100";
	String noOfPat = "1000";
	String noOfHive = "15";
	String noOfHiveCh = "15";
	String noOfHiveUser = "15";
	String noOfHiveChUser = "15";
	String appointmentModule = "Appointment/Payment";
	String fName = "Donna";
	String lName = "Lance";
	String adminEmail = "donalance@mailinator.com";
	String gender = "Female";
	
	
	@BeforeTest
	public void loginPage() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("http://vjhsoftware-001-site1.htempurl.com/");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		//static inputs
				String email = "admin@mycortex.ca";
				String pword = "P@ssw0rd";
		
				driver.findElement(By.id("username")).sendKeys(email);
				driver.findElement(By.id("password")).sendKeys(pword);
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				Thread.sleep(9000);
				driver.navigate().refresh();
				Thread.sleep(5000);
				try {
					driver.findElement(By.id("username")).sendKeys(email);
					driver.findElement(By.id("password")).sendKeys(pword);
					driver.findElement(By.xpath("//*[@type='submit']")).click();
					Thread.sleep(5000);
				} catch (NoSuchElementException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	@Test()
	public void a_institution() throws InterruptedException {
	
	//institution-----------------
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary rounded-pill btn-lg fw-medium']")));
		driver.findElement(By.xpath("//a[@class='btn btn-primary rounded-pill btn-lg fw-medium']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("institutionname")).sendKeys(InsName);
		driver.findElement(By.id("institutionshortname")).sendKeys(SHName);
		driver.findElement(By.id("email")).sendKeys(Insmail);
		
		
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("India");
		Thread.sleep(1500);
		Select state = new Select(driver.findElement(By.id("state")));
		state.selectByVisibleText("Goa");
		Thread.sleep(1500);
		Select city = new Select(driver.findElement(By.id("city")));
		city.selectByVisibleText("Bandora");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']/div/div/div[2]")).getText());
		driver.findElement(By.xpath("//div[@role='alert']/div/button")).click();
		Thread.sleep(3000);
		System.out.println("Institution created");
		Thread.sleep(5000);
	}
	
	@Test(enabled=true,dependsOnMethods="a_institution")
	public void b_subscription() throws InterruptedException {
	//subscription page---------------
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));	
		//driver.findElement(By.xpath("//a[@title='subscription']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-lg rounded-pill']")));
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg rounded-pill']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='ng-input'])[1]/input")).sendKeys(InsName+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='ng-input'])[2]/input")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='ng-option ng-star-inserted'][contains(text(),'"+timeZone+"')]")).click();
		driver.findElement(By.id("hcprof")).sendKeys(noOfHcPro);
		driver.findElement(By.id("noofpatient")).sendKeys(noOfPat);
		driver.findElement(By.id("noofhive")).sendKeys(noOfHive);
		driver.findElement(By.id("noofhivechart")).sendKeys(noOfHiveCh);
		driver.findElement(By.id("noofhiveusers")).sendKeys(noOfHiveUser);
		driver.findElement(By.id("noofhivechartusers")).sendKeys(noOfHiveChUser);
		driver.findElement(By.xpath("(//*[@class='ng-input']/input)[8]")).sendKeys(appointmentModule+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']/div/div/div[2]")).getText());
		driver.findElement(By.xpath("//div[@role='alert']/div/button")).click();
		Thread.sleep(15000);
		System.out.println("Subscription created");
		
	}
	
	@Test(enabled=false,dependsOnMethods = "b_subscription")
	public void c_admin() throws InterruptedException	{
	//admin-------------
		//driver.findElement(By.xpath("//a[@title='admin']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='btn btn-primary btn-lg rounded-pill'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn-primary btn-lg rounded-pill'])[1]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class='btn btn-primary btn-lg rounded-pill'])[1]")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("institution")));
		Select institution = new Select(driver.findElement(By.id("institution")));
		institution.selectByVisibleText(InsName);
		Thread.sleep(1500);
		driver.findElement(By.id("firstname")).sendKeys(fName);
		driver.findElement(By.id("lastName")).sendKeys(lName);
		Select gende = new Select(driver.findElement(By.id("gender")));
		gende.selectByVisibleText(gender);
		driver.findElement(By.id("email")).sendKeys(adminEmail);
		driver.findElement(By.id("mobilenumber")).sendKeys("0501245789");
		Thread.sleep(2500);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']/div/div/div[2]")).getText());
		System.out.println("Admin created");
		
	}
	
}