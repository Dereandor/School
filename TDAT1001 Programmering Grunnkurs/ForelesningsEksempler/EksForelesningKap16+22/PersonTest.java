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
    }

    @After
    public void tearDown() {
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

    public static void main(String args[]) {
		org.junit.runner.JUnitCore.main(PersonTest.class.getName());
	}

}
