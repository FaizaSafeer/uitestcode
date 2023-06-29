package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {
        private WebDriver driver;

        public PlanetPage(WebDriver driver) {
                this.driver = driver;
        }

        public List<WebElement> getPlanets() {
                List<WebElement> planets = new ArrayList<>();
                List<WebElement> planetElement = driver.findElements(By.className("planet"));
                for (WebElement planet : planetElement) {
                        planets.add(planet);
                }
                return planets;
        }


        public Planet getPlanet(Predicate<Planet> planetPredicate) throws Exception {
                for (WebElement planetElement : getPlanets()) {
                        Planet onePlanet = new Planet(planetElement);
                        if (planetPredicate.test(onePlanet))
                                return onePlanet;


                }

              throw new RuntimeException("No such element");
        }

//        public void popupMsg(){
//                WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".snackbar popup-message mr-auto")));

      //  }
}