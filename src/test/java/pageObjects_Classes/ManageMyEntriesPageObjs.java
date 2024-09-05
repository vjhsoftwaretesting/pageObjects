package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageMyEntriesPageObjs {
	
	@FindBy(id="find")
	public static WebElement findButton;
	
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
	
	//single expense entry
	@FindBy (id="expensetab")
	public static WebElement expenseTab;
	
	@FindBy (xpath="//a[@onclick='showAddExpenseEntry();']")
	public static WebElement addExpenseButton;
	
	@FindBy (xpath ="(//span[@class='select2-selection__rendered'])[5]")
	public static WebElement expClientFilter;
	
	@FindBy (xpath ="(//span[@class='select2-selection__rendered'])[6]")
	public static WebElement expProjectFilter;
	
	@FindBy (xpath ="(//span[@class='select2-selection__rendered'])[7]")
	public static WebElement expActivityFilter;
	
	@FindBy (id ="txtFrom_DateRangeExp")
	public static WebElement expFromDateFilter;
	
	@FindBy (id ="txtTo_DateRangeExp")
	public static WebElement expToDateFilter;
	
	@FindBy(xpath="//*[@id='select2-ddlExpClients_tmExpense-results']/li[1]")
	public static WebElement expCliSearchResult;
	
	@FindBy(xpath="//*[@id='select2-ddlExpProjects_tmExpense-results']/li[1]")
	public static WebElement expProSearchResult;
	
	@FindBy(xpath="//*[@id='select2-ddlExpenseType_tmExp-results']/li[1]")
	public static WebElement expActSearchResult;
	
	@FindBy(xpath="(//*[@id='grdMyEntries_Search'])[2]")
	public static WebElement expSearchFilterButton;

}
