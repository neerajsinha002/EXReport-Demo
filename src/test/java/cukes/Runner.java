package cukes;


import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.ExtentCucumberFormatter;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber-html-report","ExtentReporterNG",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml" },
        features = "src\\test\\resources\\features\\demo.feature"
        , glue = {"stepDef"}
)
public class Runner {
    @BeforeClass
    public static void setup() {
        /*ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/myreport.html");*/
        /*ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        htmlReporter.loadXMLConfig("C:\\MyWork\\EXReport-Demo\\src\\main\\resources\\proeprties\\extent-config.xml");*/
        ExtentReporter extentReporter = new ExtentHtmlReporter("extent.html");
        ((ExtentHtmlReporter) extentReporter).loadConfig("C:\\MyWork\\EXReport-Demo\\src\\main\\resources\\proeprties\\extent-config.xml");
    }
 }
