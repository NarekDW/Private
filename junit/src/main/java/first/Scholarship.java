package first;

import java.io.File;
import java.io.IOException;

/**
 * 30.03.2017 by K.N.K
 */
public interface Scholarship {
    double calculate(double coef);
    double coefDefine(int mark) throws NotSuchMarkException;
    void writeResult(File file) throws IOException;
}
