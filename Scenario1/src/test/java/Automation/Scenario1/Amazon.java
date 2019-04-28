package Automation.Scenario1;

import java.util.Map;



public class Amazon extends excelWork {
	AmazonTest attributes;
	//ITestResult result;
	@org.testng.annotations.Test(dataProvider = "extractData")
	public void AppTest(Map<String, String> map) throws Exception {
		//ExtentReports report;
		
		System.getProperties().put("webdriver.log.driver", "OFF");
		String url = map.get("Url");
		String browser =map.get("Browser");
		attributes = new AmazonTest(url, browser, "Amazon");		
		//attributes.searchForProduct(map.get("Product"));
		Thread.sleep(7000);

		attributes.selectDepartment(map.get("Department"));
		Thread.sleep(3000);

		attributes.clckOnFeshion(map.get("Feshion"));
		//attributes.generateReport(result);
		//attributes.closeBrowser();

	}	
}
