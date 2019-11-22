import models.Sighting;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void SightingInstantiatesCorrectly_True() {
        Sighting testSighting = setUpNewSighting();
        assertTrue(testSighting instanceof Sighting);

    }

    @Test
    public void SightingInstantiatesWithWildlifeId_True() {
        Sighting testSighting = setUpNewSighting();
        int testWildlifeId = 1;
        assertEquals(testWildlifeId, testSighting.getWildlifeId());
    }

    @Test
    public void SightingInstantiatesWithRangerName_True() {
        Sighting testSighting = setUpNewSighting();
        String testRangerName = "John Doe";
        assertEquals(testRangerName, testSighting.getRangerName());
    }

    @Test
    public void SightingInstantiatesWithSightingZone_True() {
        Sighting testSighting = setUpNewSighting();
        String testSightingZone = "Zone A";
        assertEquals(testSightingZone, testSighting.getSightingZone());
    }

    @Test
    public void SightingInstantiatesWithTimestamp_True() {
        Sighting testSighting = setUpNewSighting();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        assertEquals(timestamp, testSighting.getSightingTime());
    }
//
//    @Test
//    public void equalsReturnsTrueIfAttributesAreEqual() {
//        Timestamp timestamp = new Timestamp(new Date().getTime());
//        Sighting testSightingOne = setUpNewSighting();
//        Sighting testSightingTwo =new  Sighting(1, "Zone A", "John Doe", timestamp);
//        assertTrue(testSightingOne.equals(testSightingTwo));
//    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting() {
        Sighting sighting = setUpNewSighting();
        sighting.save();
        assertTrue(Sighting.all().get(0).equals(sighting));
    }

    private Sighting setUpNewSighting() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return new Sighting(1, "Zone A", "John Doe", timestamp);
    }


}