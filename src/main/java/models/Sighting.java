package models;

import java.sql.Timestamp;

public class Sighting {
    private int wildlifeId;
    private String sightingZone;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wildlifeId = wildlifeId;
        this.sightingZone = sightingZone;

    }

    public int getWildlifeId() {
        return wildlifeId;
    }

    public String getSightingZone() {
        return sightingZone;
    }
}
