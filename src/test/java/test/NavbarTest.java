package test;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class NavbarTest extends BaseTest {


    @Test(testName = "neden")
    public void test () throws InterruptedException, IOException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

        WebElement mainMenu = driver.findElement(By.xpath("//li[@id='menu-item-31740']/a/span"));
        List<WebElement> subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31740']//ul/li/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();
        Thread.sleep(1000);
        for (WebElement subMenuItem : subMenuItems) {

            String menuText = subMenuItem.getText();
            System.out.println("Menü: " + menuText);

            subMenuItem.click();
            Thread.sleep(1000);

            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(menuText), "Sayfa başlığı beklendiği gibi değil: " + menuText);

            driver.navigate().back();
            Thread.sleep(1000);

            actions.moveToElement(mainMenu).perform();
            subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31740']//ul/li/a"));
        }

        driver.close();
    }
    @Test(testName = "nasıl")
    public void testNasilMenu() throws InterruptedException, IOException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();


        WebElement mainMenu = driver.findElement(By.xpath("//li[@id='menu-item-31632']/a/span"));

        List<WebElement> subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31632']//ul/li/a"));


        Actions actions = new Actions(driver);


        actions.moveToElement(mainMenu).perform();
        Thread.sleep(1000);
        for (WebElement subMenuItem : subMenuItems) {

            String menuText = subMenuItem.getText();
            System.out.println("Menü: " + menuText);

            subMenuItem.click();
            Thread.sleep(1000);
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(menuText), "Sayfa başlığı beklendiği gibi değil: " + menuText);


            driver.navigate().back();
            Thread.sleep(1000);

            actions.moveToElement(mainMenu).perform();
            subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31632']//ul/li/a"));
        }

        driver.close();
    }
    @Test(testName = "isDunyasi")
    public void testIsDunyasi() throws InterruptedException, IOException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

        WebElement mainMenu = driver.findElement(By.xpath("//li[@id='menu-item-31623']/a/span"));

        List<WebElement> subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31623']//ul/li/a"));

        Actions actions = new Actions(driver);

        actions.moveToElement(mainMenu).perform();
        Thread.sleep(1000);
        for (WebElement subMenuItem : subMenuItems) {

            String menuText = subMenuItem.getText();
            System.out.println("Menü: " + menuText);

            subMenuItem.click();
            Thread.sleep(1000);
            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(menuText), "Sayfa başlığı beklendiği gibi değil: " + menuText);


            driver.navigate().back();
            Thread.sleep(1000);

            actions.moveToElement(mainMenu).perform();
            subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31623']//ul/li/a"));
        }

        driver.close();
    }
     @Test(testName = "yasam")
       public void testYasam() throws InterruptedException, IOException {
         driver.get("https://2nhaber.com/");
         driver.manage().window().maximize();


        WebElement mainMenu = driver.findElement(By.xpath("//li[@id='menu-item-31629']/a/span"));


        List<WebElement> subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31629']//ul/li/a"));


        Actions actions = new Actions(driver);


        actions.moveToElement(mainMenu).perform();
         Thread.sleep(1000);
        for (WebElement subMenuItem : subMenuItems) {

            String menuText = subMenuItem.getText();
            System.out.println("Menü: " + menuText);

            subMenuItem.click();
            Thread.sleep(1000);

            String actualTitle = driver.getTitle();
            Assert.assertTrue(actualTitle.contains(menuText), "Sayfa başlığı beklendiği gibi değil: " + menuText);


            driver.navigate().back();
            Thread.sleep(1000);

            actions.moveToElement(mainMenu).perform();
            subMenuItems = driver.findElements(By.xpath("//li[@id='menu-item-31629']//ul/li/a"));
        }

        driver.close();
    }
    @Test(testName = "karanlikMod")
    public void testDarkModeToggle() throws InterruptedException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

        WebElement darkModeButton = driver.findElement(By.cssSelector(".e-fas-moon > path"));
        darkModeButton.click();
        Thread.sleep(1000);




        WebElement lightModeButton = driver.findElement(By.cssSelector(".e-fas-sun"));
        lightModeButton.click();
        Thread.sleep(1000);


        Assert.assertTrue(driver.getPageSource().contains("light"), "Aydınlık mod açılmadı.");
        Thread.sleep(1000);


    }

    @Test(testName = "aramaButonu")
    public void testSearchPopup() throws InterruptedException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

        WebElement searchButton = driver.findElement(By.cssSelector(".e-fas-search"));
        searchButton.click();
        Thread.sleep(1000);

        WebElement searchPopup = driver.findElement(By.cssSelector(".elementor-widget-cmsmasters-search__popup-container"));
        Assert.assertTrue(searchPopup.isDisplayed(), "Arama kutusu açılmadı.");

        searchPopup.click();
        Thread.sleep(1000);
    }

    @Test
    public void testOffcanvasMenu() throws InterruptedException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

            driver.findElement(By.cssSelector(".elementor-widget-cmsmasters-offcanvas__trigger-icon > .e-font-icon-svg")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Yaşam")).click();
            Thread.sleep(1000);

             driver.findElement(By.linkText("İş Dünyası")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Nasıl")).click();
            Thread.sleep(1000);
            driver.findElement(By.linkText("Neden")).click();
            Thread.sleep(1000);


            String pageTitle = driver.getTitle();
            Assert.assertNotNull(pageTitle, "Sayfa başlığı boş");
        }

    }





