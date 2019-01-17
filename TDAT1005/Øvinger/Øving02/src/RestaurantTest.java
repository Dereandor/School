import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RestaurantTest {
    
    /*public RestaurantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/
    
    @Test
    public void testGetName() {
        System.out.println("Test getName: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        String expResult = "Instance";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetName() {
        System.out.println("Test setName: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        instance.setName("Instance2");
        String expResult = "Instance2";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetYear() {
        System.out.println("Test getYear: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        int expResult = 2010;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetAge() {
        System.out.println("Test getAge: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        int expResult = 9;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetFree() {
        System.out.println("Test getFree: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        int expResult = 10;
        int result = instance.getFree();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTaken() {
        System.out.println("Test getTaken: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        int expResult = 0;
        int result = instance.getTaken();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReserveTables() {
        System.out.println("Test reserveTables: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        boolean expResult = true;
        boolean result = instance.reserveTable("test", 3);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReservedName() {
        System.out.println("Test reservedTables: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        int[] expResult = {0, 1, 2};
        instance.reserveTable("test", 3);
        int[] result = instance.reservedName("test");
        String exp = Arrays.toString(expResult);
        String res = Arrays.toString(result);
        assertEquals(exp, res);
    }
    
    @Test
    public void testReleaseTables() {
        System.out.println("Test releaseTables: ");
        Restaurant instance = new Restaurant("Instance", 2010, 10);
        boolean expResult = true;
        instance.reserveTable("test", 3);
        int[] clean = {0,1,2};
        boolean result = instance.releaseTables(clean);
        assertEquals(expResult, result);
    }
}
