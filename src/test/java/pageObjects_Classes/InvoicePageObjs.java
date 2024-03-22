package pageObjects_Classes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePageObjs {
	
	@FindBy (xpath="//*[@title='Add Invoice']")
	static public WebElement addInvoiceButton;
	
	@FindBy (xpath="//*[@id='select2-chosen-1']/parent::a")
	static public WebElement invoiceClientDD;
	
	@FindBy (id="s2id_autogen1_search")
	static public WebElement cliSearchField;
	
	
	@FindBy (xpath="//*[@class='startDateTextBox']")
	static public WebElement invoiceFromDate;
	
	@FindBy (xpath="//*[@class='endDateTextBox']")
	static public WebElement invoiceToDate;
	
	@FindBy (xpath="//*[@value='Search'][@title='Search Users']")
	static public WebElement searchButton;
	
	@FindBy (xpath="//*[@class='headerstyle']/descendant::input[@type='checkbox']")
	public static WebElement dateCheckbox;
	
	@FindBy (xpath="//*[@value='Save Pre-Bill']")
	public static WebElement savePreBill;
	
	@FindBy (xpath="//*[@title='Add Invoice Batch']")
	static public WebElement addInvoiceBatchButton; 

}
