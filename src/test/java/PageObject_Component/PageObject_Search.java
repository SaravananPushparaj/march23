package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_View;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void Click_Search()
	{
		Search_btn.click();
		
	}
	
	
	public void Enter_Searchtxtbox(String Value)
	{
		Search_View.sendKeys(Value +"\n");
				
	}
	
	public String getInvalid_msg()
	{
		return Invalid_msg.getText();
	}
	
	
	public String getValid_msg()
	{
		return Valid_msg.getText();
	}
	
	
	
	

}
