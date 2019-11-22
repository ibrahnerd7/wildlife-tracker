package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {
    @Test
    public void SightingInstantiatesCorrectly_True() {
        Sighting testSighting = setUpNewSighting();
        assertTrue(testSighting instanceof Sighting);

    }

    @Test
    public void SightingInstantiatesWithWildlifeId_True(){
        Sighting testSighting=setUpNewSighting();
        int testWildlifeId=1;
        assertEquals(testWildlifeId,testSighting.getWildlifeId());

    }

    private Sighting setUpNewSighting() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return new Sighting(1, "Zone A", "John Doe", timestamp);

    }




}