package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

public class Web {

    private static WebDriver driver = null;
    private static final String dragAndDrop = "http://html5demos.com/drag";
    private static final String w3URL = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";
    private static final String  URL = "https://facebook.com/";
    private static final String expedia = "https://www.expedia.com/";
    private static final String yahoo = "https://www.yahoo.com";
    private static final String dhtxl = "https://dhtmlx.com/";
    private static final String amazon = "https://www.amazon.com/";
    private static final String hotels = "https://www.hotels.com/";
    
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Web.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void intializeWebDriver() {
       
        
        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
       driver = new ChromeDriver();
        
     /*  System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
        driver = new FirefoxDriver();*/

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//          driver.get(URL);
//        driver.get(dhtxl);
//          driver.get(expedia);
//        driver.get(amazon);
        driver.get(hotels);
        getDriver().manage().window().maximize();
    }
    
    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
    
    // This is the most common wait function used in selenium
    public static WebElement webDriverFluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .ignoring(WebDriverException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown: " + locator.toString());

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }
    // tomorrow and one week later date selection
    public static String tomarrowDate()
	{
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		
		calendar.add(Calendar.DATE, 1);
		Date tomorrow = calendar.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String tomarrowstring = formatter.format(tomorrow);
		System.out.println(tomarrowstring);
		return tomarrowstring;
	}
	public static String afterSevendayDate()
	{
		Calendar cal = Calendar.getInstance();
		Date later = cal.getTime();
		cal.add(Calendar.DATE, 8);
		Date aftersevendays = cal.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String seven = formatter.format(aftersevendays);
		System.out.println(seven);
		return seven;
	}
	public static void switchToWindow(int index) {
		List<String> list = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(list.get(index));
	}

	public static void switchToRootCloseCurrent() {
		List<String> list = new ArrayList<String>(getDriver().getWindowHandles());
		for (int i = 1; i < list.size(); i++) {
			getDriver().switchTo().window(list.get(i));
			getDriver().close();
		}
		getDriver().switchTo().window(list.get(0));
	}
}