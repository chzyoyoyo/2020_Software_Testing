

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver.get("https://www.nctu.edu.tw/");

        driver.manage().window().maximize();

        driver.findElement(By.linkText("最新消息")).click();
//        driver.findElement(By.className("random-article random-k2-article  ")).click();

        WebElement tab = driver.findElement(By.className("tab_container"));
        List<WebElement> taga = tab.findElements(By.tagName("a"));

        System.out.println(taga.get(1));
        taga.get(1).click();

        WebElement header = driver.findElement(By.id("ar-header"));
        WebElement fulltext = driver.findElement(By.className("itemFullText"));
        System.out.println(header.getText());
        System.out.println(fulltext.getText());


        driver.get("https://www.google.com.tw/");
        String number = "0856149";
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(number);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("\n");

        List<WebElement> search = driver.findElements(By.className("g"));
        System.out.println(search.get(0).findElement(By.tagName("h3")).getText());


        driver.close();

    }
}
