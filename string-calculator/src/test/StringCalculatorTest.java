// File: src/test/StringCalculatorTest.java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void testSingleNumberReturnsValue() {
        assertEquals(5, StringCalculator.add("5"));
    }

    @Test
    void testTwoNumbersReturnsSum() {
        assertEquals(8, StringCalculator.add("3,5"));
    }

    @Test
    void testMultipleNumbersReturnsSum() {
        assertEquals(15, StringCalculator.add("3,5,7"));
    }

    @Test
    void testMultiDigitReturnsSum() {
        assertEquals(1100, StringCalculator.add("30,1000,70"));
    }

    @Test
    void testLargeNumberReturnsSum() {
        assertEquals(1000003, StringCalculator.add("3,1000000"));
    }

    @Test
    void testLargeNumberWithNegativeReturnsSum() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("2,-4000,3,-5");
        });
        assertEquals("Negatives not allowed: -4000, -5", exception.getMessage());
    }


    @Test
    void testNewlineDelimiter() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void testNegativeNumbersThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("2,-4,3,-5");
        });
        assertEquals("Negatives not allowed: -4, -5", exception.getMessage());
    }
}
