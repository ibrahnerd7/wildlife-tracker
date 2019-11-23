import interfaces.Wildlife;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Endagered extends Wildlife {
    private String age;
    public int id;
    private String health;
    public static final String DATABASE_TYPE = "endagered";
    private String name;


    public Endagered(String age, String health,String name) {
        this.age = age;
        this.health = health;
        type = DATABASE_TYPE;
        this.name=name;

    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name,type,age,health) VALUES(:name,:type,:age,:health)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .executeUpdate()
                    .getKey();

        }
//        System.out.println(this.type);

    }

    public static List<Endagered> all() {
        String sql = "SELECT * FROM animals WHERE type='endagered';";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endagered.class);

        }

    }


    public static Endagered find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id=:id";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Endagered.class);
        }
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endagered endagered = (Endagered) o;
        return id == endagered.id &&
                Objects.equals(age, endagered.age) &&
                Objects.equals(health, endagered.health) &&
                Objects.equals(type, endagered.type) &&
                Objects.equals(name, endagered.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, id, health, type);
    }
}
