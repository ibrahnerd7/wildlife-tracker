package models;

import java.sql.Timestamp;

public class Sighting {
    private int wildlifeId;
    private String sightingZone;
    private String rangerName;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wildlifeId = wildlifeId;
        this.sightingZone = sightingZone;
        this.rangerName = rangerName;

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
}
