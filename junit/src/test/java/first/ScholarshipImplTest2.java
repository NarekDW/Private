package first;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * 30.03.2017 by K.N.K
 */
public class ScholarshipImplTest2 {

    private static Scholarship s;
    @BeforeClass
    public static void initScholarship(){
        System.out.println("create s...");
        s = new ScholarshipImpl();
    }

    @AfterClass
    public static void clearScholarship(){
        System.out.println("destroy s...");
        s = null;
    }

    @Test
    public void coefDefine() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = s.coefDefine(5);
        assertThat(actual, is(expected));
    }

    @SuppressWarnings("Duplicates")
    @Test
    public void calculate() {
        double basic = ScholarshipImpl.BASIC_SCHOLARSHIP;
        double coef = 1.1;
        double expected = basic*coef;
        double actual = s.calculate(coef);

        assertEquals("Some message: ",expected, actual, 0.01); // "Some message: " - only when fail!
//        assertEquals(expected, actual);
    }

}
