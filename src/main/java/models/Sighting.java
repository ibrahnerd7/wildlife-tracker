package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Sighting {
    private int wildlifeId;
    private String sightingZone;
    private String rangerName;
    private Timestamp sightingTime;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wildlifeId = wildlifeId;
        this.sightingZone = sightingZone;
        this.rangerName = rangerName;
        this.sightingTime = sightingTime;
    }

    public int getWildlifeId() {
        return wildlifeId;
    }

    public String getSightingZone() {
        return sightingZone;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getSightingTime() {
        return sightingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return wildlifeId == sighting.wildlifeId &&
                Objects.equals(sightingZone, sighting.sightingZone) &&
                Objects.equals(rangerName, sighting.rangerName) &&
                Objects.equals(sightingTime, sighting.sightingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wildlifeId, sightingZone, rangerName, sightingTime);
    }
}
