package com.kami.report;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentManager {

	public static ExtentReports extentReports;
	public static ExtentReports createInstance() {
		
		
		extentReports=new ExtentReports(System.getProperty("user.dir") +"/test-output/"+reportName());
		return extentReports;
	}
	
	public static String reportName() {
		//return "Automation-"+new SimpleDateFormat("MM.dd.yyyy").format(new Date())+".html";
		return "Automation-report.html";
	}

	static String getScreenshot(WebDriver driver)throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String scrFolderPath = System.getProperty("user.dir") + "/test-output/";
		File file = new File(scrFolderPath);
		if(file.exists() && file.isDirectory()){}else{
			new File(scrFolderPath).mkdir();
		}
		String fileName = "email_Snapshot.png";
		String destination = scrFolderPath + fileName;
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return fileName;
	}

	public static void openBrowserAndTakeScreenshot(){
		WebDriver driver=null;
		try {
			String filepath = "file:///" + System.getProperty("user.dir") + "/test-output/Automation-report.html";
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(filepath);
			getScreenshot(driver);
		}catch(Exception e){
e.printStackTrace();
		}finally {
			driver.quit();
		}
	}
}
