package UITesting;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class playgroundpage {

    @Test
    public void remotest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
       driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
driver.manage().window().maximize();
driver.findElement(By.id("forename")).sendKeys("Faiza");
driver.findElement(By.id("submit")).click();
    driver.quit();
 ;}
       @Test
    public void titletest(){
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote-allow-origins=*");
           WebDriver driver = new ChromeDriver(options);
           driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
           driver.manage().window().maximize();


           String text=driver.findElement(By.xpath("//h1[@class='display-1 mb-3']")).getText();
           System.out.println(text);

           assertEquals(text,"Web Playground");


       }


}