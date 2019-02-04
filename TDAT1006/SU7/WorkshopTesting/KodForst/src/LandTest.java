import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


class LandTest {
    private Land instance;

    @BeforeEach
    void setUp() throws Exception {
        instance = new Land("TestLand", "TestHode", 4);
        instance.regBy(new By("by1", "ordf1", 10000, 50000));
        instance.regBy(new By("by2", "ordf2", 10000, 50000));
        instance.regBy(new By("by3", "ordf3", 10000, 50000));
    }

    @AfterEach
    void tearDown() {
        instance = null;
    }


    @Test
    void testGetNavn() {
        System.out.println("Test getNavn()");
        assertEquals("TestLand", instance.getNavn());
    }

    @Test
    void testSetNavn() {
        instance.setNavn("NyttLand");
        assertEquals("NyttLand", instance.getNavn());
    }

    @Test
    void testGetStatsoverhode() {
        System.out.println("Test getStatsoverhode()");
        assertEquals("TestHode", instance.getStatsoverhode());
    }

    @Test
    void testSetStatsoverhode() {
        instance.setStatsoverhode("NyHode");
        assertEquals("NyHode", instance.getStatsoverhode());
    }

    @Test
    void testRegBy() throws Exception {
        assertTrue(instance.regBy(new By("by4", "ordf4", 10000, 50000)));
    }

}