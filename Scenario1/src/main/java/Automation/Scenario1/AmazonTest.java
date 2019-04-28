package Automation.Scenario1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;


public class AmazonTest extends excelWork{
	WebDriver driver;
	Actions action;
	int productCount = 0;
	
	AmazonReport report = new AmazonReport("Amazon Application Test");
	
	public AmazonTest(String Url, String Browser, String testCase) throws Exception {		    
		if(Browser.contains("Chrome")) {
			report.info("Opening to Chrome");
			driver = new ChromeDriver();
			report.pass("Chrome opened", Browser, driver);		
			}
		else {
			report.fail("Chrome Lunching", Browser, driver);
		}
		
		driver.get(Url);
		Thread.sleep(8);
	}
		
	public void searchForProduct(String productName) throws Exception {
		try {
		    driver.findElement(By.xpath(productSearch)).isDisplayed();
		    Assert.assertTrue(true);
		    driver.findElement(By.xpath(productSearch)).sendKeys(productName);
		    report.pass("Product searched", productName, driver);
		}catch(Exception e) {
			report.fail("Product search", productName, driver);
		}
		
	}
	
	public void selectDepartment(String departName) throws IOException {
		try {
		    report.info("Selecting Department");
		    action = new Actions(driver);
		    action.moveToElement(driver.findElement(By.xpath(hoverdepartment))).build().perform();
		    String choseDept = selectdepartment.replace("@deptName", departName);
		    driver.findElement(By.xpath(choseDept)).click();
		    report.pass("Department clicked", departName, driver);
		}catch(Exception e) {
			report.fail("Product clicked", departName, driver);
		}
	}
	
	public void clckOnFeshion(String feshionNm) throws IOException {
		report.info("Clicking on product cetagory");
		try {
		String feshion = feshionName.replace("@feshion", feshionNm);
		driver.findElement(By.xpath(feshion)).click();
		report.pass("Product Catagory clicked", feshionNm, driver);
		}catch(Exception e) {
			report.fail(e.toString(), feshionNm, driver);
		}
	}
	
	public void clickOnProductName(String productName) {
		String feshionproduct = fashionProductName.replace("@productName", productName);
		productCount = productCount+1;
		driver.findElement(By.xpath(feshionproduct)).click();
		
	}
	
	public void selectSize(String sizeValue) {
	    driver.findElement(By.xpath(dropdown)).click();
	    String size = selectSize.replace("@size", sizeValue);
	    driver.findElement(By.xpath(size)).click();
	}
	
	public void clickOnBuyingoption() {
		driver.findElement(By.xpath(buyingOption)).click();
	}
	
	public void clickOnAddToCart(String buyingOpt) {
		String  option = addToCart.replace("@OptionName", buyingOpt);
		driver.findElement(By.xpath(option)).click();
	}
	
	public void clickOnproceedToCheckOut() {
		String productCnt = Integer.toString(productCount);
		String checkout  = proceedToCheckOut.replace("@selectedProductCnt", productCnt);
		driver.findElement(By.xpath(checkout)).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
   
 
	@AfterMethod
	public void generateReport(ITestResult result) throws IOException{
	   // String screenshotPath = report.getScreenshot(driver, result.getName());
		if(result.getStatus() == ITestResult.FAILURE){
			report.logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			report.logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//report.logger.log(LogStatus.FAIL, report.logger.addScreenCapture(screenshotPath));		
		}else if(result.getStatus() == ITestResult.SKIP){
			report.logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		report.extent.endTest(report.logger);
		report.extent.flush();
	   // report.extent.close();
		closeBrowser();
		   
   }
}
