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

    private Sighting setUpNewSighting() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        return new Sighting(1, "Zone A", "John Doe", timestamp);

    }



}