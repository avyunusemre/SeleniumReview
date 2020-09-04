import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void amazonDropdownTest() {
        driver.get("http://amazon.com");
        WebElement searchBoxDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(searchBoxDropDown);
        select.selectByVisibleText("Books");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("JAVA" + Keys.ENTER);

        WebElement ilkKitap = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        ilkKitap.click();

        WebElement backToResultLinki = driver.findElement(By.partialLinkText("Back to result"));
        boolean varMi = backToResultLinki.isDisplayed();

        Assert.assertTrue(varMi);


    }
}
