package io.trepixxx.fizzbuzz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheatSheetGeneratorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void shouldPrintNumbersConvertedFrom1To100() {
        CheatSheetGenerator.print();

        String expectedPrintOfTheBeginning = "1 2 Fizz 4 Buzz Fizz Jazz 8 Fizz Buzz 11 Fizz 13 Jazz FizzBuzz 16";
        String expectedPrintOfTheEnd = "89 FizzBuzz Jazz 92 Fizz 94 Buzz Fizz 97 Jazz Fizz";

        assertTrue(outContent.toString().startsWith(expectedPrintOfTheBeginning));
        assertTrue(outContent.toString().endsWith(expectedPrintOfTheEnd));
    }
}


