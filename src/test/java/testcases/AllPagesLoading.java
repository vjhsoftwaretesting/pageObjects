package testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusable_Classes.LoginClass;

public class AllPagesLoading {
WebDriver driver;	
	
	@BeforeTest
	public void noLogin() throws InterruptedException {
		driver = new ChromeDriver();
		
		LoginClass lg = new LoginClass();
		lg.loginScript(driver);
	}
	
	@Test()
	public void Login() throws InterruptedException, MalformedURLException, IOException {
		
		List<WebElement> links=   driver.findElements(By.xpath("//li[@class='sub-menu ']/a"));
	    links.add(driver.findElement(By.id("mnu_project-home")));
	    links.add(driver.findElement(By.id("mnu_client-home")));
	    links.add(driver.findElement(By.id("mnu_schedule-home")));
		System.out.println(links.size()); 
		 
	     for(WebElement link : links)
	     {     
	      String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
	      
	      link.sendKeys(clickonlinkTab);
	      Thread.sleep(3000);
	     }
		
		
		// opens all the tabs
		/*
		 * Set<String> abc=driver.getWindowHandles();//4 Iterator<String>
		 * it=abc.iterator();
		 * 
		 * while(it.hasNext()) {
		 * 
		 * driver.switchTo().window(it.next()); System.out.println(driver.getTitle());
		 * }
		 */
			
		
	}

}
