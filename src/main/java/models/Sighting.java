package models;

import java.sql.Timestamp;

public class Sighting {
    private int wildlifeId;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wildlifeId = wildlifeId;

    }

    public int getWildlifeId() {
        return wildlifeId;
    }
}
