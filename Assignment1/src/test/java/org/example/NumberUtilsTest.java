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
    public void testEqualLengthLists() {
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(4, 5, 6);
        List<Integer> expectedOutput = Arrays.asList(5, 7, 9); // 123 + 456 = 579
        assertEquals(expectedOutput, NumberUtils.add(left, right));
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
    /////////////////////////////////////////////////////////
    @Test
    public void testLeftLongerThanRight() {
        List<Integer> left = Arrays.asList(9, 2, 3); // Extra digit in left
        List<Integer> right = Arrays.asList(4, 2);
        List<Integer> expectedOutput = Arrays.asList(9, 6, 5); // 923 + 42 = 965
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
    @Test
    public void testEmptyLists() {
        List<Integer> left = Collections.emptyList();
        List<Integer> right = Collections.emptyList();
        List<Integer> expectedOutput = Collections.emptyList();
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
    @Test
    public void testSingleElementLists() {
        List<Integer> left = Arrays.asList(0);
        List<Integer> right = Arrays.asList(0);
        List<Integer> expectedOutput = Arrays.asList(0);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
    @Test
    public void testVaryingLengths() {
        List<Integer> left = Arrays.asList(1, 2);
        List<Integer> right = Arrays.asList(1, 2, 3);
        List<Integer> expectedOutput = Arrays.asList(1, 3, 5);
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testRightLongerThanLeft() {
        List<Integer> left = Arrays.asList(4, 2);
        List<Integer> right = Arrays.asList(9, 2, 3); // Extra digit in right
        List<Integer> expectedOutput = Arrays.asList(9, 6, 5); // 42 + 923 = 965
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testSingleDigitAddition() {
        List<Integer> left = Arrays.asList(4); // Single digit
        List<Integer> right = Arrays.asList(3); // Single digit
        List<Integer> expectedOutput = Arrays.asList(7); // 4 + 3 = 7
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testMinimumAndMaximumValidDigits() {
        List<Integer> left = Arrays.asList(0, 9);  // 09
        List<Integer> right = Arrays.asList(9, 0); // 90
        List<Integer> expectedOutput = Arrays.asList(9, 9); // 09 + 90 = 99
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
    @Test
    public void testCarryPropagation() {
        List<Integer> left = Arrays.asList(9, 9, 9); // 999
        List<Integer> right = Arrays.asList(1);      // +1
        List<Integer> expectedOutput = Arrays.asList(1, 0, 0, 0); // 999 + 1 = 1000
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testCarryExactlyOne() {
        List<Integer> left = Arrays.asList(5, 5);
        List<Integer> right = Arrays.asList(5, 5);
        List<Integer> expectedOutput = Arrays.asList(1, 1, 0); // 55 + 55 = 110
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
    @Test
    public void testNoCarryAtEnd() {
        List<Integer> left = Arrays.asList(5, 5);
        List<Integer> right = Arrays.asList(4, 4);
        List<Integer> expectedOutput = Arrays.asList(9, 9); // 55 + 44 = 99 (carry never goes beyond)
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testCarryAtMiddleOnly() {
        List<Integer> left = Arrays.asList(9, 5);
        List<Integer> right = Arrays.asList(1, 5);
        List<Integer> expectedOutput = Arrays.asList(1, 1, 0); // 95 + 15 = 110
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }

    @Test
    public void testNoLeadingZeroes() {
        List<Integer> left = Arrays.asList(1, 2, 3);  // 123
        List<Integer> right = Arrays.asList(4, 5, 6); // 456
        List<Integer> expectedOutput = Arrays.asList(5, 7, 9); // 123 + 456 = 579
        assertEquals(expectedOutput, NumberUtils.add(left, right));
    }
}
