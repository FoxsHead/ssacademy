package test_task;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(test_task.test_listener.class)
@Slf4j
public class test_class_a {

    @Test (groups = "smoke")
    void test_a1() {
        log.info("Executing test_a1");
        Assert.assertEquals("A", "A");
    }
    @Test (groups= "regression")
    void test_a2() {
        log.info("Executing test_a2");
        Assert.assertEquals("B", "A");
    }
    @Test
    void test_a3() {
        log.info("Executing test_a3");
        throw new SkipException("Skip exception");
    }
}
