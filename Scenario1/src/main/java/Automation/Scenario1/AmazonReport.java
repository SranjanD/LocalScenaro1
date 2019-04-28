package Automation.Scenario1;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AmazonReport {
	//WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	
	public AmazonReport(String testCase) {
		extent = new ExtentReports (System.getProperty("user.dir") +"/Reports/AmazonReport.html", true);
		extent
        .addSystemInfo("Host Name", "SoftwareTestingMaterial")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Soumya Ranjan Das");
         extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
         
         logger = extent.startTest("AmazonTest", testCase);
	}
	
	public void info(String testCaseStep) {
		logger.log(LogStatus.INFO, testCaseStep);
	}
	
	public void pass(String desc, String scrName, WebDriver driver) throws IOException {
		 Assert.assertTrue(true);
		 String passDesc = desc+" sucessfully";
		 //logger.log(LogStatus.PASS, passDesc);
		 logger.log(LogStatus.PASS, passDesc, getScreenshot(scrName, driver));
	}
	
	public void fail(String desc, String scrName, WebDriver driver) throws IOException {
		 Assert.assertTrue(false);
		 String failDesc = desc+" not sucessfull";
		// logger.log(LogStatus.FAIL, failDesc);
		 logger.log(LogStatus.FAIL, failDesc, getScreenshot(scrName, driver));

    }
	
	public String getScreenshot(String screenshotName, WebDriver driver) throws IOException {
		File srcFile;
        srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"\\Reports\\Screenshot\\" + screenshotName +".png";
        FileHandler.copy(srcFile, new File(destination));
        return destination;
	}

}
