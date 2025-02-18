package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class NumberUtilsTest {

    @Test
    public void testNullInputBoth() {
        List<Integer> left = null;
        List<Integer> right = null;
        assertNull(NumberUtils.add(left, right));
    }

    @Test
    public void testNullInputLeft() {
        List<Integer> left = null;
        List<Integer> right = Arrays.asList(2, 3);
        assertNull(NumberUtils.add(left, right));
    }

    @Test
    public void testNullInputRight() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = null;
        assertNull(NumberUtils.add(left, right));
    }

    @Test
    public void testEmptyInputLeft() {
        List<Integer> left = Arrays.asList();
        List<Integer> right = Arrays.asList(2, 3);
        List<Integer> expectedOutput = Arrays.asList(2, 3);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testEmptyInputRight() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList();
        List<Integer> expectedOutput = Arrays.asList(2, 3);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testValidInputs() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(4, 2);
        List<Integer> expectedOutput = Arrays.asList(6, 5);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testInvalidInputLeft() {
        List<Integer> left = Arrays.asList(10, -1);
        List<Integer> right = Arrays.asList(2, 3);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testInvalidInputRight() {
        List<Integer> left = Arrays.asList(2, 3);
        List<Integer> right = Arrays.asList(10, -1);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testExplicitZeroWithEmpty() {
        List<Integer> left = Arrays.asList(0);
        List<Integer> right = Arrays.asList();
        List<Integer> expectedOutput = Arrays.asList(0);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testLeadingZeroRemoval() {
        List<Integer> left = Arrays.asList(0, 0);
        List<Integer> right = Arrays.asList(0, 0);
        List<Integer> expectedOutput = Arrays.asList(0);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testCarryCondition() {
        List<Integer> left = Arrays.asList(9, 9);
        List<Integer> right = Arrays.asList(1, 1);
        List<Integer> expectedOutput = Arrays.asList(1, 1, 0);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testInvalidDigitInInputs() {
        List<Integer> left = Arrays.asList(5, 10);
        List<Integer> right = Arrays.asList(8, -1);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testAllValidDigits() {
        List<Integer> left = Arrays.asList(3, 5);
        List<Integer> right = Arrays.asList(4, 2);
        List<Integer> expectedOutput = Arrays.asList(7, 7);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testLeftDigitNegative() {
        List<Integer> left = Arrays.asList(-1, 3);
        List<Integer> right = Arrays.asList(4, 2);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testLeftDigitTooLarge() {
        List<Integer> left = Arrays.asList(10, 3);
        List<Integer> right = Arrays.asList(4, 2);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testRightDigitNegative() {
        List<Integer> left = Arrays.asList(3, 5);
        List<Integer> right = Arrays.asList(-1, 2);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void testRightDigitTooLarge() {
        List<Integer> left = Arrays.asList(3, 5);
        List<Integer> right = Arrays.asList(4, 10);
        try {
            NumberUtils.add(left, right);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}
