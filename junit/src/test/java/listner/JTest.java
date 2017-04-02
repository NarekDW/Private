package listner;

import first.NotSuchMarkException;
import first.Scholarship;
import first.ScholarshipImpl;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * 31.03.2017 by K.N.K
 */
@RunWith(ListenerRunner.class)
public class JTest {
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
        File file = folder.newFile("a:/result.txt");
        s.writeResult(file);
        assertTrue(file.length() != 0);
    }

    @Ignore("Experiment ignore for listener.")
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
