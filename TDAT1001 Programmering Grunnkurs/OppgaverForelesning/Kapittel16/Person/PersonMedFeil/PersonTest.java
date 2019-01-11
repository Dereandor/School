
import org.junit.*;
import static org.junit.Assert.*;

/**
 *  PersonTest.java
 * @author gs
 * Developed during workshop TDAT1001 - JUnit Testing.
 * This is a junit test class - testing the class PersonWithErrors
 */
public class PersonTest {
	private Person instance;

    public PersonTest() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
   		 instance = new Person(100, "Ole", "Hansen");
    }

    @After
    public void tearDown() {
    	instance = null;
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        System.out.println("Person: toString");
        String expResult = "100 Ole Hansen";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEtternavn method, of class Person.
     */
    @Test
    public void testGetEtternavn() {
        System.out.println("Person: getEtternavn");
        String expResult = "Hansen";
        String result = instance.getEtternavn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEtternavn method, of class Person.
     */
    @Test
    public void testSetEtternavn() {
        System.out.println("Person: setEtternavn");
        String expResult = "Jensen";
        instance.setEtternavn(expResult);
        String result = instance.getEtternavn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFornavn method, of class Person.
     */
    @Test
    public void testGetFornavn() {
        System.out.println("Person: getFornavn");
        String expResult = "Ole";
        String result = instance.getFornavn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFornavn method, of class Person.
     */
    @Test
    public void testSetFornavn() {
        System.out.println("Person: setFornavn");
        String expResult = "Per";
        instance.setFornavn(expResult);
        String result = instance.getFornavn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPersonnr method, of class Person.
     */
    @Test
    public void testGetPersonnr() {
        System.out.println("Person: getPersonnr");
        int expResult = 100;
        int result = instance.getPersonnr();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPersonnr method, of class Person.
     */
    @Test
    public void testSetPersonnr() {
        System.out.println("Person: setPersonnr");
        int expResult = 200;
        instance.setPersonnr(expResult);
        int result = instance.getPersonnr();
        assertEquals(expResult, result);
    }
    /**
     * Multiple tests of equals method, of class Person.
     */

    @Test
    public void testEquals(){
    	System.out.println("Person: equals");
    	boolean expResult = true;
    	Person p2 = instance;
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }

    @Test
    public void testEquals1(){
    	System.out.println("Person: equals 1");
    	boolean expResult = true;
    	Person p2 = new Person(100, "Ole", "Hansen");
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }

    @Test
    public void testEquals2(){
    	System.out.println("Person: equals 2");
    	boolean expResult = false;
    	Person p2 = new Person(100, null, "Hansen");
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }

    @Test
    public void testEquals3(){
    	System.out.println("Person: equals 3");
    	boolean expResult = false;
    	Person p2 = new Person(100, "Ole", null);
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }
    @Test
    public void testEquals4(){
    	System.out.println("Person: equals 4");
    	boolean expResult = false;
    	Person p2 = new Person(100, "Olle", "Hansen");
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }

    @Test
    public void testEquals5(){
    	System.out.println("Person: equals 5");
    	boolean expResult = false;
    	Person p2 = new Person(100, "Ole", "Hanssen");
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }
    @Test
    public void testEquals6(){
    	System.out.println("Person: equals 6");
    	boolean expResult = false;
    	Person p2 = null;
    	boolean result = instance.equals(p2);
    	assertEquals(expResult, result);
    }

    public static void main(String args[]) {
	  org.junit.runner.JUnitCore.main(PersonTest.class.getName());
    }

}
