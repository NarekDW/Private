package first;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/**
 * 30.03.2017 by K.N.K
 */
public class ScholarshipImplTest {

    private Scholarship s;
    @Before // Before every test method
    public void initScholarship(){
//        System.out.println("create s...");
        s = new ScholarshipImpl();
    }

    @After // After every test method
    public void clearScholarship(){
//        System.out.println("destroy s...");
        s = null;
    }

    @Test
    public void coefDefine() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = s.coefDefine(5);
        assertThat(actual, is(expected));
    }

    @Test
    public void calculate() {
        double basic = ScholarshipImpl.BASIC_SCHOLARSHIP;
        double coef = 1.1;
        double expected = basic*coef;
        double actual = s.calculate(coef);

        assertEquals("Some message: ",expected, actual, 0.01); // "Some message: " - only when fail!
//        assertEquals(expected, actual);
    }





    @Test
    public void test(){
        fail("Message in fail: ");
    }

    @Test
    public void test2(){
        assumeTrue(false); // without exception
    }
}