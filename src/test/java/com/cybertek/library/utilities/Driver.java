package com.cybertek.library.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private Driver() {}
    //share the object using ThreadLocal,
    // variables will be created with specific variables.
    // Each object will have their version of vars

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;
    private static URL url;
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
//System.getProperty reads is from command line "mvn test -Dbrowser=remote-chrome"
            //if it has a value, use that value
            //if no value is passed from command line, it gets it from properties file
            // mvn test -Dcucumber.filter.tags=@regression -Dbrowser=remote-chrome
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions=new ChromeOptions();
                    // I need chrome to start maximized when running via the selenium grid.
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver());
                    break;
                case "remote-chrome":
                    chromeOptions = new ChromeOptions();
                    try {
                        //mvn clean verify -DBROWSER=chrome
                        URL url = new URL("http://34.203.215.182:4444/wd/hub");
                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    firefoxOptions = new FirefoxOptions();
                    try {
                        //mvn verify -DBROWSER=firefox
                        URL url = new URL("http://34.203.215.182:4444/wd/hub");
                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    //     OR long way
                    //ChromeOptions options = new ChromeOptions();
                    //options.setHeadless(true);
                    //driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverPool.set(new InternetExplorerDriver());
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverPool.set(new SafariDriver());
                    break;
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
//String url = null;
//if(System.getProperty("env")!=null){
//url = Configuration.getProperty(System.getProperty("env")+"_url");
// -Denv=qa1
//}else{
//url = Configuration.getProperty("url");

