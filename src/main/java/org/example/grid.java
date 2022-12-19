package main.java.org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.Arrays;
import java.util.HashMap;

public class grid  {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static WebDriver getWebDriver() {
        return driver.get();
    }
    //  public static ThreadLocal<WebDriver> Driver = new ThreadLocal<WebDriver>();

    public static void setWebDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
    public static void initBrowser() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities("chrome", "", Platform.ANY);
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
        chromePrefs.put("credentials_enable_service", "false");
        chromePrefs.put("profile.password_manager_enabled", "false");
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("download.extensions_to_open","jar");
        chromePrefs.put("safebrowsing.enabled", "true");
        chromePrefs.put("acceptInsecureCerts",true);
        chromePrefs.put("download.default_directory","C:\\Users\\vanshika.vashisht\\Downloads");
        ChromeOptions chromeOptions = new ChromeOptions();
        //   ChromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.addArguments("test-type", "start-maximized", "no-default-browser-check");
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--safebrowsing-disable-extension-blacklist");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("test-type");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        chromeOptions.addArguments("window-size=1980,960");

        driver.set(new RemoteWebDriver(new URL("http://13.232.225.222:4444/"), capabilities));
      /*  System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\vanshika.vashisht\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();

        // Maximize the browser
     /*   driver.manage().window().maximize();
*/
        // Launch Website
        driver.get("https://www.geeksforgeeks.org/");

    }


}