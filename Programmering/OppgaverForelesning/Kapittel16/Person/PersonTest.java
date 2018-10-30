/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gs-dell
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
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
        Person instance = new Person(100, "Ole", "Hansen");
        instance.setPersonnr(expResult);
        int result = instance.getPersonnr();
        assertEquals(expResult, result);
    }

    /**
    * Test of equals method, of class person
    */
    @Test
    public void testEquals1() {
        System.out.println("Person: equals1");
        boolean expResult = true;
        Person instance2 = instance;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals2() {
        System.out.println("Person: equals2");
        boolean expResult = true;
        Person instance2 = new Person(100, "Ole", "Hansen");
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals3() {
        System.out.println("Person: equals3");
        boolean expResult = false;
        Person instance2 = new Person(100, null, "Hansen");
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals4() {
        System.out.println("Person: equals4");
        boolean expResult = false;
        Person instance2 = new Person(100, "Ole", null);
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals5() {
        System.out.println("Person: equals5");
        boolean expResult = false;
        Person instance2 = new Person(100, "Olle", "Hansen");
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals6() {
        System.out.println("Person: equals6");
        boolean expResult = false;
        Person instance2 = new Person(100, "Ole", "Hanssen");
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals7() {
        System.out.println("Person: equals7");
        boolean expResult = false;
        Person instance2 = null;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
    }
    public static void main(String args[]) {
	  org.junit.runner.JUnitCore.main(PersonTest.class.getName());
    }

}
