package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planet {
    private final WebElement planetElement;
    public Planet(WebElement planetElement) {
        this.planetElement = planetElement;

    }

    public String getName() {
        return planetElement.findElement(By.className("name")).getText();
    }

    public void clickExplore() {
        planetElement.findElement(By.tagName("button")).click();

    }


    public long getDistance(){


        var DisString=planetElement.findElement(By.className("distance")).getText();
        return Long.parseLong(DisString.replaceAll("^//d",""));



    }
}
