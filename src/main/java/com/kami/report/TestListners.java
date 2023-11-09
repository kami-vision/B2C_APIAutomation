package com.kami.report;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners implements ITestListener {

	
	private static ExtentReports extent=ExtentManager.createInstance();
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	private static int failCount;

	public static void addCategory(String category) {
		extentTest.get().assignCategory(category);
    }
    @Override
	public void onTestStart(ITestResult result) {
		ExtentTest test=extent.startTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		if(result.getMethod().getDescription()!=null)
		test.setDescription("<h4>Test Description:"+result.getMethod().getDescription()+"</h4>");
		extentTest.set(test);
		failCount=0;
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		if(failCount>0){
			result.setStatus(2);
		}
		pass("<b>Test Method "+result.getMethod().getMethodName()+" is Successfully</b>");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ifail("<b><font color=\"red\">Test Method "+result.getMethod().getMethodName()+" is Failed<font></b>"
				+ "<pre>"+result.getThrowable().getMessage()+"</pre>");
		//extentTest.get().log(LogStatus.FAIL,Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",", "<br>"));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(LogStatus.SKIP,"<b>Test Method "+result.getMethod().getMethodName()+" is Skipped</b>");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		if(extent!=null) {
			extent.flush();
		}
		ExtentManager.openBrowserAndTakeScreenshot();
	}
	
	public static void fail(String msg) {
		extentTest.get().log(LogStatus.FAIL,"<b><font color=\"red\">"+msg+"<font></b>");
		failCount++;
	}

	private static void ifail(String msg) {
		extentTest.get().log(LogStatus.FAIL,msg);
	}
	
	public static void pass(String msg) {
		extentTest.get().log(LogStatus.PASS,msg);
	}
	
	public static void info(String msg) {
		extentTest.get().log(LogStatus.INFO,msg);
	}

}
