import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    //1. Amazon'a gideceğiz
    //2. Arama kutusuna "baby stroller" yazacağız
    //3. 2. sıradaki ürüne tıklayacağız
    //4. Ürünün sayfasına gittikten sonra ürünün toplam fiyatını alacağız
    //5. Ürünün ortalama puanını alacağız



    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller" + Keys.ENTER);

        WebElement secondOption = driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[4]"));
        secondOption.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement totalPrice = driver.findElement(By.xpath("(//span[@class='p13n-sc-price'])[1]"));
        System.out.println(totalPrice.getText());

        driver.close();

    }


}
