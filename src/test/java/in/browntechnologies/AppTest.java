package in.browntechnologies;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private Set testSet = new HashSet();


    @RepeatedTest(10)
    public void runTest() {
        App app = new App();
        BigInteger uniqueRandomBigInt = app.uniqueRandomBigInt();
        assertTrue(
                !uniqueRandomBigInt.toString().isEmpty() && uniqueRandomBigInt.toString().length() == 16,
                "Failed to generate unique random integer -" + uniqueRandomBigInt + ", found empty or null."
        );
    }


    /**
     * Stress test to generate random number for 60 seconds and check if there is any duplicate.
     */
    @Test
    public void testApp() {
        Long startTime = System.currentTimeMillis();
        App app = new App();
        while ((System.currentTimeMillis() - startTime) < (1000 * 60)) {
            BigInteger uniqueRandomBigInt = app.uniqueRandomBigInt();
            assertFalse(
                    testSet.contains(uniqueRandomBigInt),
                    "Failed to generate unique random ID, found duplicate -> " + uniqueRandomBigInt
            );
            testSet.add(uniqueRandomBigInt);
        }
        assertTrue(true);
    }
}
