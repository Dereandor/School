import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class KalkisTest {

    Kalkis instance; // Deklarerer Kalkis-objektet her.

    @BeforeClass
    public static void setUpClass() throws Exception {
		// database-innlogging - opprette en filstrom.. el
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
      // database.logut, lukke filer..
    }

    @Before
    public void setUp() {
		/* oppretter nytt Kalkis-objekt her, alternativt kan vi opprette et nytt objekt i den enkelte test-metoden */
		instance = new Kalkis();
    }

    @After
    public void tearDown() {
		instance = null;
    }

    @Test
    public void testPluss() {
        System.out.println("pluss");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.pluss(x, y);
        assertEquals(expResult, result, delta);
    }

    @Test
    public void testMinus() {
        System.out.println("minus");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.minus(x, y);
        assertEquals(expResult, result, delta);
    }

    @Test
    public void testGange() {
        System.out.println("gange");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = 0.0;
        double result = instance.gange(x, y);
        assertEquals(expResult, result, delta);
   }

	// flere feiltester i samme metode forer til at kun forste feil rapporteres.
	// bor vurdere aa dele opp i kun en test pr testmetode
    @Test
    public void testDivisjon() {
        System.out.println("divisjon");
        double x = 0.0;
        double y = 0.0;
        double delta  = 0.0001; // hvor noyaktig like maa tallene vaere?
        double expResult = Double.NaN;
        double result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 1

        x = 0.0;
        y = 1.0;
        expResult = 0.0;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta); // test 2

        x = 1.0;
        y = 0.0;
        expResult = Double.POSITIVE_INFINITY;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 3

        x = 1.0;
        y = 1.0;
        expResult = 1.0;
        result = instance.divisjon(x, y);
        assertEquals(expResult, result, delta);  // test 4
    }

    @Test(expected=ArithmeticException.class)
    public void testDiv(){
		System.out.println("testDiv (int)");
		instance.div(1,0);
    }
	// maa endre til long - da den nye pcen bruker mye lenger tid på å timeout..
	@Test(timeout=10)  // Hva skjer om du endrer denne til 10-100-1000?
	public void tidsbegr(){
		System.out.println("tidsbegr");
		// ny laptop (1000 ok/ 100 !ok)
		//		Long i = 0L;
		//		for(i=0; i<Integer.MAX_VALUE*Integer.MAX_VALUE*Integer.MAX_VALUE; i++); // for-lokke som teller langt for å simulere at testen timerout

		// mac: 1000 ok, 10 !ok
		int i = 0;
		for(i=0; i<Integer.MAX_VALUE; i++); // for-lokke som teller langt for å simulere at testen timerout

		assertTrue("Likhet" ,i==Integer.MAX_VALUE*Integer.MAX_VALUE*Integer.MAX_VALUE);
	}

	@Ignore("uferdig test - blir ikke tatt med som i testkjoringen")
	@Test
    public void testNoe(){
		//System.out.println("ignore");
		assertEquals("hei", "hEi");
	}

    public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main(KalkisTest.class.getName()); // tas med dersom textpad ikke er konfigurert
    }
}

/* Kjoring av programmet :  (E = Exception, I = Ignore)
JUnit version 4.12
.testDiv (int)
I.gange
.minus
.pluss
.divisjon
.tidsbegr
E
Time: 0,109
There was 1 failure:
1) tidsbegr(KalkisTest)
org.junit.runners.model.TestTimedOutException: test timed out after 100 milliseconds
	at KalkisTest.tidsbegr(KalkisTest.java:110)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:298)
	at org.junit.internal.runners.statements.FailOnTimeout$CallableStatement.call(FailOnTimeout.java:292)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.lang.Thread.run(Thread.java:745)

FAILURES!!!
Tests run: 6,  Failures: 1


*/