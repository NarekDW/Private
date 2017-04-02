package first;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * 30.03.2017 by K.N.K
 */
public class ScholarshipImplTest3 {

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

    /*
    * If method must throw exception.
    * check as ob is instanceof NotSuchMarkException.class
    * */
    @Test (expected = NotSuchMarkException.class)
    public void coefDefine() throws NotSuchMarkException {
        double expected = 1.5;
        double actual = s.coefDefine(21);
        // При впоявлении исключения, метод дальше не пойдет.
        fail("Method don't throw NotSuchMarkException...");
        assertThat(actual, is(expected));
    }


    @Ignore("This test is fail by default.")
    @Test(timeout = 10) // 10ms не успевает выполнится тест и выкидывается ошибка теста TestTimedOutException
    public void timeCoef() throws NotSuchMarkException {
        for(int i = 0; i<100_000; i++){
            double expected = 1.5;
            double actual = s.coefDefine(5);
            assertThat(actual, is(expected));
        }
    }
}
