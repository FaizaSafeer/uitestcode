package UITesting;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

       }


}