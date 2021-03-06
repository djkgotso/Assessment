package api_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class SearchByValidTitle 
{
	@BeforeTest
	public void TestAPI(){
		System.out.println("Testing API's");
		System.out.println("**********************");
	}
	
	
	//The bellow method is the first one to be called when executing
	@Test(priority=1,dataProvider = "API_Test")
	public void Search_API_Test(String SearchID,String APIKey) throws InterruptedException, IOException 
	{
		Search_Valid_Title(SearchID,APIKey);

	}
	
	//The method is called on the above method when executing and it collect the test data populate into PostMan running in the background
	public void Search_Valid_Title(String SearchID,String APIKey) 
	{
		//String SearchIDs = "tt3501632";
		//String APIKey = "d1730fe7";
		String Appurl = "http://www.omdbapi.com/?i="+SearchID+"&apikey="+APIKey+"";
	
		try {

			RequestBody formBody = new FormBody.Builder().add("ID", "" + SearchID + "").build();	

			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(""+Appurl+ "")
					.post(formBody).addHeader("content-Type", "application/json")
					.addHeader("accept", "application/json").addHeader("cache-control", "no-cache")
					.addHeader("authorization", "Bearer").build();
			
			System.out.println(request);

			okhttp3.Response response = client.newCall(request).execute();

			int Code = response.code();
			System.out.println("Response :" + response.body().string());
			Reporter.log("Response :" + response);
			Assert.assertEquals(Code, 200);

		} catch (MalformedURLException ex) 
		{
			ex.printStackTrace();
			Assert.fail();

		} catch (IOException e) 
		{

			e.printStackTrace();
			Assert.fail();

		}


	}
	
	//The bellow method is reading data from Excel file. Change the Data from the Excel to experience error messages or search different Movies
	@DataProvider(name = "API_Test")
	public Object[][] provideTestParam(ITestContext context) {
		String ExcelLocation = context.getCurrentXmlTest().getParameter("ExcelLocation");
		Object[][] retObjArr = { { ExcelLocation } };
		//ExcelLocation = "QA";
		try {
			File path = new File("/Users/kgotsomashabea/Documents/TestData.xlsx");
			FileInputStream file = new FileInputStream(path);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			sheet.iterator();

			retObjArr = new Object[sheet.getPhysicalNumberOfRows() - 1][2];
			for (int rownum = 0; rownum < sheet.getPhysicalNumberOfRows() - 1; rownum++) {
				Row row = sheet.getRow(rownum + 1);

				retObjArr[rownum][0] = row.getCell(0).getStringCellValue();
				retObjArr[rownum][1] = row.getCell(1).getStringCellValue();

			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (retObjArr);
	}

}
