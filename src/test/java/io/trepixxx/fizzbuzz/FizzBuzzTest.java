package io.trepixxx.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.trepixxx.fizzbuzz.FizzBuzz.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTest {

    @ValueSource(ints = {1, 4, 11, 58, 98})
    @ParameterizedTest(name = "number \"{0}\" is converted to {0}")
    void givenNonFizzNorBuzzNumber_ThenReturnThisNumber(Integer number) {
        assertEquals(number.toString(), convert(number));
    }


    @ValueSource(ints = {3, 6, 33, 99})
    @ParameterizedTest(name = "number \"{0}\" is converted to Fizz")
    void givenFizzButNotBuzzNumber_ThenReturnFizz(Integer number) {
        assertEquals("Fizz", convert(number));
    }


    @ValueSource(ints = {5, 10, 50, 95})
    @ParameterizedTest(name = "number \"{0}\" is converted to Buzz")
    void givenBuzzButNotFizzNumber_ThenReturnBuzz(Integer number) {
        assertEquals("Buzz", convert(number));
    }

    @ValueSource(ints = {15, 30, 45, 90})
    @ParameterizedTest(name = "number \"{0}\" is converted to FizzBuzz")
    void givenFizzBuzzNumber_ThenReturnFizzBuzz(Integer number) {
        assertEquals("FizzBuzz", convert(number));
    }
}

