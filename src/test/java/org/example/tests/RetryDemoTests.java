package org.example.tests;

import org.example.listeners.CustomTestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class RetryDemoTests {

    private static int test3Counter = 0;

    @Test(priority = 1)
    public void test1_AlwaysPass() {
        System.out.println("Executing Test 1 - This will pass");
        Assert.assertTrue(true, "Test 1 passed");
    }

    @Test(priority = 2)
    public void test2_AlwaysFail() {
        System.out.println("Executing Test 2 - This will always fail");
        Assert.fail("Test 2 intentionally fails to verify retry mechanism");
    }

    @Test(priority = 3)
    public void test3_PassOnRetry() {
        test3Counter++;
        System.out.println("Executing Test 3 - Attempt #" + test3Counter);
        if (test3Counter < 2) {
            Assert.fail("Test 3 fails on first attempt");
        }
        // Passes on second attempt (retry)
        Assert.assertTrue(true, "Test 3 passed on retry");
    }
}