package io.trepixxx.fizzbuzz;

import org.junit.jupiter.api.Test;

import static io.trepixxx.fizzbuzz.FizzBuzz.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @Test
    void givenNonFizzNorBuzzNumber_ThenReturnThisNumber() {
        assertEquals("1", convert(1));
        assertEquals("4", convert(4));
        assertEquals("7", convert(7));
    }


    @Test
    void givenFizzButNotBuzzNumber_ThenReturnFizz() {
        assertEquals("Fizz", convert(3));
        assertEquals("Fizz", convert(33));
        assertEquals("Fizz", convert(99));
    }
}

