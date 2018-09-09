package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class ExtentReporterNG implements IReporter {
    private ExtentReports extentReports;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        extentReports = new ExtentReports(outputDirectory + File.separator + "Extent.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }
        extentReports.flush();
        extentReports.close();
    }

    private void buildTestNodes(IResultMap iResultMap, LogStatus status) {
        ExtentTest extentTest;

        if (iResultMap.size() > 0) {
            for (ITestResult result : iResultMap.getAllResults()) {
                extentTest = extentReports.startTest(result.getMethod().getMethodName());

                extentTest.setStartedTime(getTime(result.getStartMillis()));
                extentTest.setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    extentTest.assignCategory(group);

                if (result.getThrowable() != null) {
                    extentTest.log(status, result.getThrowable());
                } else {
                    extentTest.log(status, "Test " + status.toString().toLowerCase()
                            + "ed");
                }
                extentReports.endTest(extentTest);
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
