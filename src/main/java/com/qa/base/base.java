package com.qa.base;

import com.qa.utilities.TestUtil;
import com.qa.utilities.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {


    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public base()
    {
        try
        {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com/qa//config//config.properties");
        prop.load(fis);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void initialization()
    {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//chromedriver.exe"));
            driver = new ChromeDriver();
        }

        else if (browserName.equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//geckodriver.exe"));
            driver = new FirefoxDriver();
        }

        else if (browserName.equals("Opera"))
        {
            System.setProperty("webdriver.opera.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//operadriver.exe"));
            driver = new OperaDriver();
        }

        else if (browserName.equals("Edge"))
        {
            System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + "//src//main//java//com//qa//executables//msedgedriver.exe"));
            driver = new EdgeDriver();
        }


        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }


}
