package listner;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * 31.03.2017 by K.N.K
 */
public class ListenerRunner extends BlockJUnit4ClassRunner {
    private TestListener testListener;
    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public ListenerRunner(Class<?> klass) throws InitializationError {
        super(klass);
        testListener = new TestListener();
    }

    public void run(RunNotifier notifier){
        notifier.addListener(testListener);
        super.run(notifier);
    }
}
