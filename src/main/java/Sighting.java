import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int wildlifeId;
    private String sightingZone;
    private String rangerName;
    private Timestamp sightingTime;
    private int id;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wildlifeId = wildlifeId;
        this.sightingZone = sightingZone;
        this.rangerName = rangerName;
        this.sightingTime = sightingTime;
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM persons";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);

        }
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

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO persons(id,wild_life_id,zone,ranger_name,time) VALUES(:id,:sightingZone,rangerName,sightingTime)";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .addParameter("wild_life_id", this.wildlifeId)
                    .addParameter("zone", this.sightingZone)
                    .addParameter("ranger_name", this.rangerName)
                    .addParameter("time", this.sightingTime)
                    .executeUpdate();
        }
    }
}
