package first;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Тесты для ВВОДА-ВЫВОДА
 * с настройками, установка временного файла(после теста уничтожается)
 * установка времени выполнения теста Timeout
 * установка ожидаемых исключений
 *
 * 30.03.2017 by K.N.K
 */
public class ScholarshipImplTest4 {
    private static Scholarship s;
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();
    @Rule
    public final Timeout timeout = new Timeout(2, TimeUnit.SECONDS);
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void initScholarship(){
        s = new ScholarshipImpl();
    }

    @AfterClass
    public static void clearScholarship(){
        s = null;
    }

    @Test
    public void writeResult() throws IOException {
        File file = folder.newFile("result.txt");
        s.writeResult(file);
        assertTrue(file.length() != 0);
    }

    @Test
    public void exception1() throws NotSuchMarkException {
        thrown.expect(NotSuchMarkException.class);
        s.coefDefine(21);
    }

    @Test
    public void exception2() throws IOException {
        thrown.expect(NullPointerException.class);
        s.writeResult(null);
    }
}
