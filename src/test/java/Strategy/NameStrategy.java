package Strategy;

import models.Planet;

public class NameStrategy implements MatchingStrategy{

    String name;


    @Override
    public boolean match(Planet planet) {
        return planet.getName().equalsIgnoreCase(name);
    }
}

