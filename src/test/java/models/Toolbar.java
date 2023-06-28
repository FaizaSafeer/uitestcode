package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Toolbar {
    WebDriver driver;
    public Toolbar(WebDriver driver) {
        this.driver=driver;

    }

    public void clickForm() {
        driver.findElement(By.cssSelector("a[aria-label=forms]")).click();
    }
}
