package listner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * 30.03.2017 by K.N.K
 */
public class TestListener extends RunListener {

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Тест стартовал: "+description.getMethodName()+"  "+description.getClassName());
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Тест завершен: "+description.getMethodName()+"  "+description.getClassName());
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Тест провален: "+failure.getException());
    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Тест игнорирован: "+description.getMethodName()+"\n----");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Результаты выполнения тестов:");
        System.out.println("Время выполнения: "+result.getRunTime()+" мс");
        System.out.println("Было запущено тестов: "+result.getRunCount());
        System.out.println("Провалено тестов: "+result.getFailureCount());
        System.out.println("Игнорировано тестов: "+result.getIgnoreCount());
        System.out.println("Все тесты завершены успешно: "+result.wasSuccessful());
        System.out.println("result.getFailures() = "+result.getFailures());
    }
}
