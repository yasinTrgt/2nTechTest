package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {// WebDriver kurulum
        System.setProperty("webdriver.chrome.driver", "/Users/yasin/Downloads/chromedriver-mac-arm64/chromedriver"); // Chromedriver'ın doğru yolu
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        System.out.println("BaseTest: WebDriver kuruldu ve tarayıcı açıldı.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("BaseTest: WebDriver kapatıldı.");
        }
    }


    }





