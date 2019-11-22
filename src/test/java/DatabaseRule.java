import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() throws Throwable {
        DB.sql2o = new Sql2o("jdbc://localhost:5432/wildlifes_test", "moringa", "Access");
    }

    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()) {
            String deleteSightingsQuery = "DELETE FROM sightings";
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }
}
