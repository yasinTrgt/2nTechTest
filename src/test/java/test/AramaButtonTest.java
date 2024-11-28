package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class AramaButtonTest extends BaseTest {

    @Test
    public void testSearch() throws InterruptedException {
        driver.get("https://2nhaber.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".e-fas-search")));
        searchButton.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".elementor-widget-cmsmasters-search__field")));
        searchInput.sendKeys("İstanbul");
        searchInput.submit();


        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 2; i++) {
            jse.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
        }


        List<WebElement> newsArticles = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\'cmsmasters_body\']/div[2]/div/div/section[2]/div/div[1]")));
        Assert.assertFalse(newsArticles.isEmpty(), "Hiç haber bulunamadı.");
        System.out.println("Mevcut Haber Sayısı: " + newsArticles.size());


        int targetArticleIndex = 1;
        // Hedef sıra . Burada 8 yapınca bulamıyor kod çıktısında 1 haber bulundu olarak görnüyor.
        int zeroBasedIndex = targetArticleIndex - 1;

        Assert.assertTrue(newsArticles.size() >= targetArticleIndex,
                "Arama sonuçlarında yeterli haber bulunamadı. Mevcut haber sayısı: " + newsArticles.size());


        WebElement targetArticle = newsArticles.get(zeroBasedIndex);
        String targetArticleTitle = targetArticle.getText();
        System.out.println("Seçilen Haber Başlığı: " + targetArticleTitle);

        targetArticle.click();


    }

}



