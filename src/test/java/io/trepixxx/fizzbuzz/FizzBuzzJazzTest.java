package io.trepixxx.fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.trepixxx.fizzbuzz.FizzBuzzJazz.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzJazzTest {

    @ValueSource(ints = {1, 4, 11, 58, 97})
    @ParameterizedTest(name = "number \"{0}\" is converted to {0}")
    void givenNonFizzNorBuzzNorJazzNumber_ThenReturnThisNumber(Integer number) {
        assertEquals(number.toString(), convert(number));
    }


    @ValueSource(ints = {3, 6, 33, 99})
    @ParameterizedTest(name = "number \"{0}\" is converted to Fizz")
    void givenFizzButNotBuzzNorJazzNumber_ThenReturnFizz(Integer number) {
        assertEquals("Fizz", convert(number));
    }

    @ValueSource(ints = {5, 10, 50, 95})
    @ParameterizedTest(name = "number \"{0}\" is converted to Buzz")
    void givenBuzzButNotFizzNorJazzNumber_ThenReturnBuzz(Integer number) {
        assertEquals("Buzz", convert(number));
    }


    @ValueSource(ints = {7, 14, 49, 98})
    @ParameterizedTest(name = "number \"{0}\" is converted to Jazz")
    void givenJazzButNotFizzNorBuzzNumber_ThenReturnJazz(Integer number) {
        assertEquals("Jazz", convert(number));
    }

    @ValueSource(ints = {15, 30, 45, 90})
    @ParameterizedTest(name = "number \"{0}\" is converted to FizzBuzz")
    void givenFizzBuzzNumberButNotJazz_ThenReturnFizzBuzz(Integer number) {
        assertEquals("FizzBuzz", convert(number));
    }

    @ValueSource(ints = {21, 42, 63})
    @ParameterizedTest(name = "number \"{0}\" is converted to FizzJazz")
    void givenFizzJazzButNotBuzzNumber_ThenReturnFizzJazz(Integer number) {
        assertEquals("FizzJazz", convert(number));
    }
}

