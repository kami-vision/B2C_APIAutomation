package com.kami.report;

import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-blink-features", "BlockCredentialedSubresources");
			chromeOptions.addArguments("--start-fullscreen");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			Thread.sleep(10000);
			driver.get(filepath);
			getScreenshot(driver);
			Thread.sleep(10000);
		}catch(Exception e){
e.printStackTrace();
		}finally {
			driver.quit();
		}
	}
}
