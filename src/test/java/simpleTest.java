import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class simpleTest {

    private static WebDriver driver;

    @BeforeClass

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "/home/yaroslav/Work/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.delivery-club.ru/");
    }

    @Test

    public void SearchSpace() {
        WebElement searchSpace = driver.findElement(By.xpath("//*[@id='user-addr__input']"));
        searchSpace.clear();
        searchSpace.sendKeys("Кемерово, улица Сибиряков-Гвардейцев, 16");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='user-addr__form']/label[2]/a"));
        enterButton.click();
        WebElement restaurant = driver.findElement(By.xpath("//*[@id='vendor-list-app']/div/div[2]/div[6]/ul/li[2]/section/div[2]/section[1]/a/span"));
        String restaurantName = restaurant.getText();
        Assert.assertEquals("СУШИ ТЕРРА", restaurantName);
        WebElement enterRestaurantButton = driver.findElement(By.xpath("//*[@id='vendor-list-app']/div/div[2]/div[6]/ul/li[2]/section/div[2]/section[1]/a/span"));
        enterRestaurantButton.click();
        WebElement orderButton = driver.findElement(By.cssSelector("#content > ul:nth-child(9) > li:nth-child(2) > form > p > a"));
        orderButton.click();
        WebElement basketButton = driver.findElement(By.cssSelector("#middle > div.cart_2.from_basket > a.button.alt.open_basket.from_basket"));
        basketButton.click();
        WebElement productName = driver.findElement(By.xpath("//*[@id='popup']/div[2]/div[4]/form/ul/li/dl/dt"));
        String product = productName.getText();
        Assert.assertEquals("Лава", product);

    }
}
