package io.trepixxx.fizzbuzz.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FizzRuleTest {

    private ZzRule fizzRule;

    @BeforeEach
    void instanceRule() {
        fizzRule = new FizzRule();
    }

    @ValueSource(ints = {3, 6, 21, 60, 99})
    @ParameterizedTest(name = "number \"{0}\" meets the Fizz Rule because it's multiple of 3")
    void shouldReturnTrue_BecauseTheyAreMultipleOfThree(Integer number) {
        assertTrue(fizzRule.meets(number));
    }

    @ValueSource(ints = {13, 33, 37, 43, 93})
    @ParameterizedTest(name = "number \"{0}\" meets the Fizz Rule because it contains a 3")
    void shouldReturnTrue_BecauseTheyContainAThreeDigit(Integer number) {
        assertTrue(fizzRule.meets(number));
    }

    @ValueSource(ints = {1, 4, 11, 29, 40, 97})
    @ParameterizedTest(name = "number \"{0}\" does not meet the Fizz Rule")
    void shouldReturnFalse_BecauseTheyAreNotMultipleOfThreeAndDoNotContainAThree(Integer number) {
        assertFalse(fizzRule.meets(number));
    }

    @Test
    void shouldReturnFizz() {
        assertEquals("Fizz", fizzRule.getNameZZ());
    }
}
