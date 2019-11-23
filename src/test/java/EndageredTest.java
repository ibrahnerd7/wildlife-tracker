import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndageredTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void EndageredInstantiatesCorrectly_True() {
        Endagered testEndagered = setUpNewEndagered();
        assertTrue(testEndagered instanceof Endagered);
    }

    private Endagered setUpNewEndagered() {
        return new Endagered("young", "healthy","lioness");
    }

    @Test
    public void testAnimalInstantiatesWithAge_True() {
        Endagered testEndagered = setUpNewEndagered();
        String testEndageredAge = "young";
        assertEquals(testEndageredAge, testEndagered.getAge());
    }

    @Test
    public void testAnimalInstantiatesWithName_True() {
        Endagered testEndagered = setUpNewEndagered();
        String testEndageredName = "lioness";
        assertEquals(testEndageredName, testEndagered.getName());
    }

    @Test
    public void equalsReturnsTrueIfAttributesAreEqual() {
        Endagered testEndagered = setUpNewEndagered();
        Endagered testEndageredTwo = setUpNewEndagered();
        assertEquals(testEndagered, testEndageredTwo);
    }

    @Test
    public void save_insertsObjectIntoDatabase_Endagered() {
        Endagered testEndagered = setUpNewEndagered();
        testEndagered.save();
        assertEquals(Endagered.all().get(0), testEndagered);
    }


    @Test
    public void all_returnsAllInstancesOfEndagered_true() {
        Endagered testEndagered = setUpNewEndagered();
        testEndagered.save();
        Endagered testEndageredTwo = setUpNewEndagered();

        testEndageredTwo.save();
        System.out.println(Endagered.all().size());
        assertEquals(Endagered.all().get(0), testEndagered);
        assertEquals(Endagered.all().get(1), testEndageredTwo);
    }

    @Test
    public void save_assignsIdToAnimal() {
        Endagered testEndagered = setUpNewEndagered();
        testEndagered.save();
        Endagered savedAnimal = Endagered.all().get(0);
        assertEquals(testEndagered.getId(), savedAnimal.getId());
    }
//
//    @Test
//    public void find_returnsAnimalWithSameId_secondAnimal() {
//        Endagered testEndagered = setUpNewEndagered();
//        testEndagered.save();
//        Endagered testEndageredTwo = setUpNewEndagered();
//        testEndageredTwo.save();
//        assertEquals(Endagered.find(testEndageredTwo.getId()), testEndageredTwo);
//    }


}