package com.kami.report;

import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentManager {

	public static ExtentReports extentReports;
	public static ExtentReports createInstance() {
		
		
		extentReports=new ExtentReports(System.getProperty("user.dir") +"/test-output/"+reportName());
		return extentReports;
	}
	
	public static String reportName() {
		return "Automation-"+new SimpleDateFormat("MM.dd.yyyy").format(new Date())+".html";
	}
}
