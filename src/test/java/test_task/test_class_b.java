package test_task;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

@Listeners(test_task.test_listener.class)
@Slf4j
public class test_class_b {

    @BeforeMethod
    public void beforeMethod() {
        log.info("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        log.info("After Method");
    }
    @BeforeClass
    public void beforeClass() {
        log.info("Before Class");
    }
    @AfterClass
    public void afterClass() {
        log.info("After Class");
    }
    @BeforeTest
    public void beforeTest() {
        log.info("Before Test");
    }
    @AfterTest
    public void afterTest() {
        log.info("After Test");
    }
    @BeforeSuite
    public void beforeSuite() {
        log.info("Before Suite");
    }
    @AfterSuite
    public void afterSuite() {
        log.info("After Suite");
    }
    @BeforeGroups("smoke")
    public void smoke1() {
        log.info("Start of smoke tests");
    }
    @BeforeGroups("regression")
    public void regression1() {
        log.info("Start of regression tests");
    }

    @AfterGroups("smoke")
    public void smoke2() {
        log.info("End of smoke tests");
    }
    @AfterGroups("regression")
    public void regression2() {
        log.info("End of regression tests");
    }

    @Test(groups= "smoke")
    void test_b1() {
        log.info("Executing test_b1");
        Assert.assertEquals("2", "2");
    }
    @Test(groups= "regression")
    void test_b2() {
        log.info("Executing test_b2");
        Assert.assertEquals("2", "1");
    }
    @Test
    void test_b3() {
        log.info("Executing test_b3");
        throw new SkipException("Skip exception");
    }

}
