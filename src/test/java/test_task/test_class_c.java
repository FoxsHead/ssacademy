package test_task;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(test_task.test_listener.class)
@Slf4j
@DisableListener
public class test_class_c {

    @Test (groups = "smoke")
    void test_c1() {
        log.info("Executing test_c1");
        Assert.assertEquals("A", "A");
    }
    @Test (groups= "regression")
    void test_c2() {
        log.info("Executing test_c2");
        Assert.assertEquals("B", "A");
    }
    @Test
    void test_c3() {
        log.info("Executing test_c3");
        throw new SkipException("Skip exception");
    }

}
