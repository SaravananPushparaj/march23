package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	 SoftAssert sAssert = new SoftAssert();
	 static Logger log=Logger.getLogger(Scenario_Search.class);
	
	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"smoke"})
	public void test_InvalidSearch(String TC_ID, String Order, String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase "+TC_ID+ "  Order is  "+Order);
		
		Start_Server();
		Init_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_Wait(BS_Pob.Search_btn,25);
		BS_Pob.Click_Search();
		
		Explicit_Wait(BS_Pob.Search_View,25);
		BS_Pob.Enter_Searchtxtbox(Search_Item);
		
		
		
		Explicit_Wait(BS_Pob.Invalid_msg,25);
		String Actual_Result = BS_Pob.getInvalid_msg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			snapshot1(TC_ID, Order);
			log.info("Passed as Expected is " +Exp_Result +"and Actual msg are same" +Actual_Result);
		}
		else
		{
			snapshot1(TC_ID, Order);
			sAssert.fail("Failed as Expected is " +Exp_Result +"and Actual msg are different" +Actual_Result);
			log.info("Failed as Expected is " +Exp_Result +"and Actual msg are different" +Actual_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}
	

	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"regression"})
	public void test_ValidSearch(String TC_ID, String Order, String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase "+TC_ID+ "  Order is  "+Order);
		
		Start_Server();
		Init_App();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_Wait(BS_Pob.Search_btn,25);
		BS_Pob.Click_Search();
		
		Explicit_Wait(BS_Pob.Search_View,25);
		BS_Pob.Enter_Searchtxtbox(Search_Item);
		
		
		Explicit_Wait(BS_Pob.Valid_msg,25);
		
		String Output = BS_Pob.getValid_msg();
		String Actual_Result = Output.replace(" products", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			snapshot1(TC_ID, Order);
			log.info("Passed as Expected is " +Exp_Result +"and Actual msg are same" +Actual_Result);
		}
		else
		{
			snapshot1(TC_ID, Order);
			sAssert.fail("Failed as Expected is " +Exp_Result +"and Actual msg are different" +Actual_Result);
			log.info("Failed as Expected is " +Exp_Result +"and Actual msg are different" +Actual_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}
}
