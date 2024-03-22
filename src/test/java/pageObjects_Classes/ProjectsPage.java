package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage {
	
	@FindBy(id="mnu_project-home")
	public  static WebElement projectModule;
	
	@FindBy(linkText ="Add Project")
	public static WebElement addProject;
	
	@FindBy(id="select2-ddlClient_pd-container")
	public static WebElement clientDD;
	
	@FindBy(className ="select2-search__field")
	public static WebElement clientSearchField;
	
	@FindBy(id ="txtProjectName_pd")
	public static WebElement projectNameFiled;
	
	@FindBy(id="save_CloseProject")
	public static WebElement saveCloseProject;	
	

}
