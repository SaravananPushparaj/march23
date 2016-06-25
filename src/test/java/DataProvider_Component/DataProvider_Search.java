package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Search {

	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<String[]> getInvalidSearch() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Invalid_Search");	
		return Obj.iterator();
		
		
	}
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<String[]> getvalidSearch() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Valid_Search");	
		return Obj.iterator();
		
		
	}
	
	
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\June_BB_Project\\Test_Data\\Test_Data.xls");
		HSSFSheet Search_Scenario = xl.Setsheet("Search_Scenario");
		
		int RowCount = xl.getrowcount(Search_Scenario);
		List<String[]> search_list= new ArrayList<String[]>();
		
		for(int iRow=1;iRow<=RowCount;iRow++)
		{
			
			String Execute_Flag = xl.Readvalue(Search_Scenario, iRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Search_Scenario, iRow, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(scriptname)))
			{
				String[] arr_search= new String[4];
				
				arr_search[0]=xl.Readvalue(Search_Scenario, iRow, "TC_ID");
				arr_search[1]=xl.Readvalue(Search_Scenario, iRow, "Order");
				arr_search[2]=xl.Readvalue(Search_Scenario, iRow, "Search_Item");
				arr_search[3]=xl.Readvalue(Search_Scenario, iRow, "Exp_Result");				
				arr_search[3]=arr_search[3].replace(".0", "");
				
				search_list.add(arr_search);			
				
				
			}		
			
			
		}
		
		return search_list;
		
		
	}
	
	
}
