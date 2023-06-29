package Strategy;

import models.Planet;

public class DistanceMatchStrategy implements MatchingStrategy{
     private final long distance;

    public DistanceMatchStrategy(long distance) {
        this.distance = distance;
    }

    @Override
    public boolean match(Planet planet) {
        return false;
    }
}
