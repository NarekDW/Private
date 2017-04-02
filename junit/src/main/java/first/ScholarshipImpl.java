package first;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 30.03.2017 by K.N.K
 */
public class ScholarshipImpl implements Scholarship {
    public static final double BASIC_SCHOLARSHIP = 100;
    @Override
    public double calculate(double coef) {
        return BASIC_SCHOLARSHIP*coef;
    }

    @Override
    public double coefDefine(int mark) throws NotSuchMarkException {
        double coef;
        switch (mark){
            case 3:
                coef = 1.0;
                break;
            case 4:
                coef = 1.3;
                break;
            case 5:
                coef = 1.5;
                break;
            default:
                throw new NotSuchMarkException("There is no mark: "+mark);
        }
        return coef;
    }

    @Override
    public void writeResult(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.append(this.toString());
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("result.txt");
        ScholarshipImpl s = new ScholarshipImpl();
        s.writeResult(file);
        System.out.println(file.length());
    }
}
