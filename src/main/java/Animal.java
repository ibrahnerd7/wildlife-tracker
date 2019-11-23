import interfaces.Wildlife;
import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Animal implements Wildlife {
    private int id;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES(:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.getName())
                    .executeUpdate()
                    .getKey();

        }
        System.out.println(this.id);

    }


    public static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);

        }
    }

    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId() {

    }

    @Override
    public void setName() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
