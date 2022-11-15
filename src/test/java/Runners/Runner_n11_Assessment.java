package Runners;

import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(
        tags ="@Nurhayat",
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
)

@Listeners({ExtentITestListenerClassAdapter.class})

public class Runner_n11_Assessment extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("QA Tester", "Nurhayat Köklü");
        ExtentService.getInstance().setSystemInfo("Application Name", "n11");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Description", "Assessment");
    }
}
