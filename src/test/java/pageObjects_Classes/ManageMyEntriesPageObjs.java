package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageMyEntriesPageObjs {
	
	@FindBy(id="find")
	public static WebElement fingButton;
	
	@FindBy(xpath="//*[@id='clientsFilterDiv']/descendant::select[@id='ddlClients_tmExpense']/following::span[5]")
	public static WebElement clientFilter;
	
	@FindBy(xpath="//*[@id='clientsFilterDiv']/descendant::select[@id='ddlProjects_tmExpense']/following::span[5]")
	public static WebElement projectFilter;
	
	@FindBy(xpath="//*[@id='activityFilterDiv']/descendant::select[@id='ddlActivityType_tmExp']/following::span[5]")
	public static WebElement activityFilter;
	
	@FindBy(xpath="//*[@class='select2-search__field']")
	public static WebElement searchField;
	
	@FindBy(xpath="//*[@id='select2-ddlClients_tmExpense-results']/li[1]")
	public static WebElement cliSearchResult;
	
	@FindBy(xpath="//*[@id='select2-ddlProjects_tmExpense-results']/li[1]")
	public static WebElement proSearchResult;
	
	@FindBy(xpath="//*[@id='select2-ddlActivityType_tmExp-results']/li[1]")
	public static WebElement actSearchResult;
	
	@FindBy(id="txtFrom_DateRange")
	public static WebElement fromDateFilter;
	
	@FindBy(id="txtTo_DateRange")
	public static WebElement toDateFilter;
	
	@FindBy(id="grdMyEntries_Search")
	public static WebElement searchFilterButton;
	
	@FindBy(id="statusTime1")
	public static WebElement pendingFilter;
	
	@FindBy(id="statusTime2")
	public static WebElement submittedFilter;
	
	@FindBy(id="statusTime4")
	public static WebElement approvedFilter;
	
	@FindBy(id="statusTime3")
	public static WebElement rejectedFilter;
	
	@FindBy(xpath="//*[@name='MyEntries_btnSubmit']")
	public static WebElement inlineSubmitButton;
	
	@FindBy(xpath="//*[@name='MyEntries_btnApprove']")
	public static WebElement inlineApproveButton;
	
	
	@FindBy(xpath="//*[@class='inline-te-buttons']/input[2]")
	public static WebElement inlineRevertPendingButton;
	
	@FindBy(id="submitButton")
	public static WebElement submitButton;
	
	@FindBy(id="approveButton")
	public static WebElement approveButton;
	
	@FindBy(id="deleteButton")
	public static WebElement deleteButton;
	
	@FindBy(id="UnsubmitButton")
	public static WebElement revertPendingButton;
	
	


}
