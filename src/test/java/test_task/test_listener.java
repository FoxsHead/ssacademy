package test_task;

import lombok.extern.slf4j.Slf4j;
import org.testng.*;
import org.testng.internal.ConstructorOrMethod;

@Slf4j
public class test_listener implements ITestListener, IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        ConstructorOrMethod consOrMethod =iInvokedMethod.getTestMethod().getConstructorOrMethod();
        DisableListener disable = consOrMethod.getMethod().getDeclaringClass().getAnnotation(DisableListener.class);
        if (disable != null) {
            return;
        }
    }
    @Override
    public void onStart(ITestContext arg) {
        log.info("Start of " + arg.getName());
    }
    @Override
    public void onTestStart(ITestResult arg) {
        log.info("Start of (test)"+ arg.getName());
    }
    @Override
    public void onTestSuccess(ITestResult arg) {
        log.info(arg.getName()+" passed.");
    }
    @Override
    public void onTestFailure(ITestResult arg) {
        log.error(arg.getName()+" failed.");
    }
    @Override
    public void onTestSkipped(ITestResult arg) {
        log.info(arg.getName()+" skipped.");
    }
    @Override
    public void onFinish(ITestContext arg) {
        log.info("End of " +arg.getName());
    }
}
