package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GeneralWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(){

        System.out.println("Test scenario started");

    }
    @After
    public void after(Scenario scenario) {

        System.out.println("Test scenario ended");
        System.out.println("Test scenario result="+ scenario.getStatus());
        System.out.println("Scenario isFailed ?="+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yy");

        ExcelUtility.writeExcel("src/test/java/ExcelReport/ScenarioStatus.xlsx", scenario, GeneralWebDriver.threadBrowserName.get(), date.format(formatter));

        if (scenario.isFailed()){
            TakesScreenshot screenshot = (TakesScreenshot) GeneralWebDriver.getDriver();
            File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);

       //     ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());
            try {
                FileUtils.copyFile(ekranDosyasi,
                        new File("target/FailedScreenShots/"+ scenario.getId()+"_"+date.format(formatter2)+".png"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        GeneralWebDriver.quitDriver();

    }
    public String getBase64Screenshot()
    {
        return ((TakesScreenshot) GeneralWebDriver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
