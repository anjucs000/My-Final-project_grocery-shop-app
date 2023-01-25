package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*public class ExtendReportUtility {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
	//String path =System.getProperty("user.dir")+"\\reports\\index.html";
	String path= "C:\\Users\\anjuc\\eclipse-workspace\\FinalProject\\reports\\index.html";

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");

	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Anju");
	return extent;

	}*/

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtendReportUtility {
	public static final ExtentReports extentReports = new
			ExtentReports();
			public synchronized static ExtentReports createExtentReports() {

			ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

			reporter.config().setReportName("Sample Extent Report");
			extentReports.attachReporter(reporter);
			extentReports.setSystemInfo("Blog Name", "SW Test Academy");
			extentReports.setSystemInfo("Author", "Onur Baskirt");
			return extentReports;
			}
}

