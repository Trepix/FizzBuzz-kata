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
    @ParameterizedTest(name = "number \"{0}\" meets the Fizz Rule")
    void shouldReturnTrue_BecauseTheyMeetFizzRule(Integer number) {
        assertTrue(fizzRule.meets(number));
    }

    @ValueSource(ints = {1, 4, 11, 32, 97})
    @ParameterizedTest(name = "number \"{0}\" does not meet the Fizz Rule")
    void shouldReturnFalse_BecauseTheyDoNotMeetFizzRule(Integer number) {
        assertFalse(fizzRule.meets(number));
    }

    @Test
    void shouldReturnFizz() {
        assertEquals("Fizz", fizzRule.getNameZZ());
    }
}
