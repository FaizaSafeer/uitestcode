package test;

import models.Form;
import models.Toolbar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class playgroundTests {

    private WebDriver driver;

    private String URL = "https://d18u5zoaatmpxx.cloudfront.net/#/";

    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void demotest() {

        driver.get(URL);

        driver.findElement(By.id("forename")).sendKeys("Faiza");
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void titleTest() {


        String text = driver.findElement(By.cssSelector("h1.mb-3")).getText();
        // String text=driver.findElement(By.xpath("//h1[@class='display-1 mb-3']")).getText();
        System.out.println(text);
        Assertions.assertEquals("Web Playground", text);
        //assertEquals(text,"Web Playground");

    }

    @Test
    public void clickDownTest() {

        By buttonBY = By.cssSelector("a.anibtn");
        driver.findElement(buttonBY).click();

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(buttonBY, "CLICK ME UP!"));

        Assertions.assertEquals("CLICK ME UP!", driver.findElement(buttonBY).getText());

    }

    @Test
    public void clickUPTest() {
        By buttonBY = By.cssSelector("a.anibtn");
        driver.findElement(buttonBY).click();
        //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(buttonBY, "CLICK ME UP!"));

        driver.findElement(buttonBY).click();
        // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(buttonBY, "CLICK ME DOWN!"));

        Assertions.assertEquals("CLICK ME DOWN!", driver.findElement(buttonBY).getText());


    }

    @Test
    public void fillForm() {

        new Toolbar(driver).clickForm();


        Form form = new Form(driver);
        form.enterName("Faiza");
        form.enterEmail("faiza@gmail.com");
        form.selectState("NSW");
        form.clickAgree();
        form.submit();

        By welcomeBy = By.cssSelector("div.snackbar");
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBy));

        Assertions.assertEquals("Thanks for your feedback Faiza", driver.findElement(welcomeBy).getText());


    }

    @Test
    public void explorePlanet() throws InterruptedException {
        new Toolbar(driver).clickPlanets();

        ////h2[@class='name headline primary--text']
        List<WebElement> allPlanets=driver.findElements(By.cssSelector(".planet+h2"));

        for (WebElement planet:allPlanets) {
             if(planet.getText().equalsIgnoreCase("Earth")){
                 Thread.sleep(2000);
                 planet.click();
             }

        }



    }


    @AfterEach
    public void cleanUp() {
        driver.quit();
    }

    private static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

}