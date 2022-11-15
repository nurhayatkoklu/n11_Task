package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneralWebDriver {

    public static WebDriver driver;
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver() {

        if (driver == null) {
            threadBrowserName.set("firefoxMy ");

          // extend report türkçe OS çalışmaması sebebiyle kondu
          //cale.setDefault(new Locale("EN"));
          //stem.setProperty("user.language", "EN");

            //Log'u sessize almak için kondu
            Logger.getLogger("").setLevel(Level.SEVERE);
            System.setProperty("webdriver.gecko.driver","C:\\Automation\\geckodriver-v0.26.0-win64\\geckodriver.exe" );
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");

            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        return driver;

    }

    public static void quitDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) { // driver varsa
            driver.quit();
            driver = null;
        }


}
        public static void Bekle ( int saniye){
            try {
                Thread.sleep(saniye * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
}
