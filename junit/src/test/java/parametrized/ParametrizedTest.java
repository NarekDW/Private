package parametrized;

import first.NotSuchMarkException;
import first.Scholarship;
import first.ScholarshipImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 30.03.2017 by K.N.K
 */
@RunWith(Parameterized.class)
public class ParametrizedTest {
    private int mark;
    private double coef;

    public ParametrizedTest(int mark, double coef) {
        this.mark = mark;
        this.coef = coef;
    }

    @Parameters
    public static Collection<Object[]> initCoef(){
        return Arrays.asList(new Object[][]{
                {3, 1.0},
                {4, 1.3},
                {5, 1.5}
        });
    }

    @Test
    public void test() throws NotSuchMarkException {
        Scholarship s = new ScholarshipImpl();
        System.out.println("coef = "+coef+"\nmark = "+mark+"\n\n");
        double expected = this.coef;
        double actual = s.coefDefine(this.mark);
        assertThat(actual, is(expected));
    }

}
