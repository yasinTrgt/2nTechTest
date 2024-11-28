package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;


public class BasvuruTest extends BaseTest {


    @Test(dataProvider = "loginData")
    public void test (String name, LocalDate date,String tck,String telNo,String mail) throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.2ntech.com.tr/hr");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.findElement(By.xpath("//input[@id=\'name\']")).click();
        Thread.sleep(4000);
        WebElement adSoyad = driver.findElement(By.id("name"));
        adSoyad.sendKeys(name);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\'birth\']")).click();
        Thread.sleep(4000);
        WebElement dogumTarihi = driver.findElement(By.id("birth"));
        String formattedDate = date.getDayOfMonth() + "/" +  date.getMonthValue()+ "/" + date.getYear();
        dogumTarihi.sendKeys(formattedDate);
        Thread.sleep(4000);
        driver.findElement(By.id("tcKimlik")).click();
        Thread.sleep(3000);
        WebElement tcKimlik = driver.findElement(By.id("tcKimlik"));
        tcKimlik.sendKeys(tck);
        Thread.sleep(3000);
        driver.findElement(By.id("phone")).click();
        Thread.sleep(3000);
        WebElement tel = driver.findElement(By.id("phone"));
        tel.sendKeys(telNo);
        Thread.sleep(3000);
        driver.findElement(By.id("email")).click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(mail);
        Thread.sleep(3000);

        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]/div/label")));
        //element.sendKeys("//Users/yasin/Desktop/Yasin Turgut CV-pdf.pdf");
        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[5]/div/button[5]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/form/div[7]/button")).click();
        Thread.sleep(3000);

        driver.close();


    }
    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][]{
                {"Yasin Turgut",LocalDate.parse("1992-03-10"), "12312312323",
                "05558686108","yasin_9207@hotmail.com"}

        };

    }


}