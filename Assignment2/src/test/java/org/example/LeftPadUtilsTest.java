package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftPadUtilsTest {

    @Test
    public void testNullString() {
        // Test case for `str` being null. Should return null.
        String str = null;
        int size = 5;
        String padStr = "*";
        String expectedOutput = null;
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testEmptyString() {
        // Test case for `str` being empty. Should pad to the specified size with the given padStr.
        String str = "";
        int size = 5;
        String padStr = "*";
        String expectedOutput = "*****";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testNoPaddingNeeded() {
        // Test case where the `str` length is greater than or equal to `size`. Should return the original string.
        String str = "hello";
        int size = 5;
        String padStr = "*";
        String expectedOutput = "hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testPadWithNullPadStr() {
        // Test case where `padStr` is null. Should use a single space as padding.
        String str = "hello";
        int size = 10;
        String padStr = null;
        String expectedOutput = "     hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testPadWithEmptyPadStr() {
        // Test case where `padStr` is empty. Should use a single space as padding.
        String str = "hello";
        int size = 10;
        String padStr = "";
        String expectedOutput = "     hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testPadWithExactPadding() {
        // Test case where the length of `padStr` matches the required padding. Should prepend `padStr`.
        String str = "hello";
        int size = 10;
        String padStr = "*****";
        String expectedOutput = "*****hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testPadWithPartialPadding() {
        // Test case where `padStr` is longer than the required padding. Should use a substring of `padStr`.
        String str = "hello";
        int size = 8;
        String padStr = "*******";
        String expectedOutput = "***hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testPadWithRepeatedPadding() {
        // Test case where `padStr` is shorter than the required padding. Should repeat `padStr` as needed.
        String str = "hello";
        int size = 10;
        String padStr = "abc";
        String expectedOutput = "abcabhello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testNegativeSize() {
        // Test case where `size` is negative. Should return the original string.
        String str = "hello";
        int size = -1;
        String padStr = "*";
        String expectedOutput = "hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }

    @Test
    public void testZeroSize() {
        // Test case where `size` is zero. Should return the original string.
        String str = "hello";
        int size = 0;
        String padStr = "*";
        String expectedOutput = "hello";
        assertEquals(expectedOutput, LeftPadUtils.leftPad(str, size, padStr));
    }
}