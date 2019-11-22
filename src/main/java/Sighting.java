import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int wild_life_id;
    private String zone;
    private String ranger_name;
    private Timestamp time;
    private int id;

    public Sighting(int wildlifeId, String sightingZone, String rangerName, Timestamp sightingTime) {
        this.wild_life_id = wildlifeId;
        this.zone = sightingZone;
        this.ranger_name = rangerName;
        this.time = sightingTime;
    }

    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);

        }
    }

    public int getWildlifeId() {
        return wild_life_id;
    }

    public String getSightingZone() {
        return zone;
    }

    public String getRangerName() {
        return ranger_name;
    }

    public Timestamp getSightingTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sighting sighting = (Sighting) o;
        return wild_life_id == sighting.wild_life_id &&
                Objects.equals(zone, sighting.zone) &&
                Objects.equals(ranger_name, sighting.ranger_name) &&
                Objects.equals(time, sighting.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wild_life_id, zone, ranger_name, time);
    }

    public void save() {
        System.out.println(this.wild_life_id);
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (wild_life_id,zone,ranger_name,time) VALUES(:wild_life_id,:zone,:ranger_name,:time)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("wild_life_id", this.getWildlifeId())
                    .addParameter("zone", this.getSightingZone())
                    .addParameter("ranger_name", this.getRangerName())
                    .addParameter("time", this.getSightingTime())
                    .executeUpdate()
                    .getKey();
        }
    }

    public int getId() {
        return id;
    }
}
