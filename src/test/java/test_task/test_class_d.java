package test_task;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Slf4j
@Listeners(test_task.test_listener.class)
public class test_class_d {
    @DataProvider(name = "test_provider")

    public Object[][] dataProviderMethod(Method x) {
        switch (x.getName()) {
            case "sum":
                return new Object[][] {{2, 3, 5}, {5, 7, 9}};
            case "diff":
                return new Object[][] {{2, 3, -1}, {5, 7, -2}};
        }
        return null;
    }

    @Test(dataProvider = "test_provider")
    public void Sum (int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
        log.info("Sum "+result);
    }

    @Test (dataProvider = "test_provider")
    public void Diff (int a, int b, int result) {
        int diff = a - b;
        Assert.assertEquals(result, diff);
        log.info("Diff "+result);
    }
}
