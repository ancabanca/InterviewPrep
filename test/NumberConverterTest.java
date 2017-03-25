import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.NumberConverter;
import java.io.FileNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberConverterTest {
    private static NumberConverter converter;

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        converter = new NumberConverter("en");
    }

    // exceptions
    @Test(expected = UnsupportedOperationException.class)
    public void testNumberConverter_UnsupportedOperationException_UnsupportedLanguage() throws FileNotFoundException {
        converter = new NumberConverter("fr");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNumberConverter_UnsupportedOperationException_UnsupportedNumber_Negative() throws FileNotFoundException {
        converter.convert(-5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNumberConverter_UnsupportedOperationException_UnsupportedNumber_TooBig() throws FileNotFoundException {
        converter.convert(1000000000);
    }

    // 0-9
    @Test
    public void testNumberConverter_Digit() {
        assertEquals("five", converter.convert(5));
    }

    // 11-19
    @Test
    public void testNumberConverter_Teen() {
        assertEquals("fifteen", converter.convert(15));
    }

    // 10~90
    @Test
    public void testNumberConverter_Ten1() {
        assertEquals("ten", converter.convert(10));
    }

    @Test
    public void testNumberConverter_Ten2() {
        assertEquals("fifty", converter.convert(50));
    }

    @Test
    public void testNumberConverter_Ten3() {
        assertEquals("ninety", converter.convert(90));
    }

    // 21-99
    @Test
    public void testNumberConverter_TenDigit1() {
        assertEquals("twenty one", converter.convert(21));
    }

    @Test
    public void testNumberConverter_TenDigit2() {
        assertEquals("forty seven", converter.convert(47));
    }

    @Test
    public void testNumberConverter_TenDigit3() {
        assertEquals("ninety nine", converter.convert(99));
    }

    // 100-999
    @Test
    public void testNumberConverter_Hundred1() {
        assertEquals("one hundred", converter.convert(100));
    }

    @Test
    public void testNumberConverter_Hundred2() {
        assertEquals("five hundred", converter.convert(500));
    }

    @Test
    public void testNumberConverter_HundredDigit() {
        assertEquals("five hundred one", converter.convert(501));
    }

    @Test
    public void testNumberConverter_HundredTeen() {
        assertEquals("five hundred eleven", converter.convert(511));
    }

    @Test
    public void testNumberConverter_HundredTen() {
        assertEquals("five hundred seventy", converter.convert(570));
    }

    @Test
    public void testNumberConverter_HundredTenDigit() {
        assertEquals("nine hundred ninety nine", converter.convert(999));
    }

    // 1000-999,999
    @Test
    public void testNumberConverter_Thousand() {
        assertEquals("two thousand", converter.convert(2000));
    }

    @Test
    public void testNumberConverter_ThousandDigit() {
        assertEquals("thirty three thousand three", converter.convert(33003));
    }

    @Test
    public void testNumberConverter_ThousandTenDigit() {
        assertEquals("four hundred eleven thousand twenty four", converter.convert(411024));
    }

    @Test
    public void testNumberConverter_ThousandHundred() {
        assertEquals("eighty one thousand nine hundred", converter.convert(81900));
    }

    @Test
    public void testNumberConverter_ThousandHundredTenDigit1() {
        assertEquals("one thousand nine hundred ninety eight", converter.convert(1998));
    }

    @Test
    public void testNumberConverter_ThousandHundredTenDigit2() {
        assertEquals("nine hundred ninety nine thousand nine hundred ninety nine", converter.convert(999999));
    }

    // 1,000,000-999,999,999
    @Test
    public void testNumberConverter_Million() {
        assertEquals("five million", converter.convert(5000000));
    }

    @Test
    public void testNumberConverter_MillionTeen() {
        assertEquals("five million seventeen", converter.convert(5000017));
    }

    @Test
    public void testNumberConverter_TenMillion() {
        assertEquals("forty eight million", converter.convert(48000000));
    }

    @Test
    public void testNumberConverter_MillionMax() {
        assertEquals("nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine", converter.convert(999999999));
    }
}