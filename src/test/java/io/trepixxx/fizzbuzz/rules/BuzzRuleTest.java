package io.trepixxx.fizzbuzz.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BuzzRuleTest {

    private ZzRule buzzRule;

    @BeforeEach
    void instanceRule() {
        buzzRule = new BuzzRule();
    }

    @ValueSource(ints = {5, 10, 60, 95})
    @ParameterizedTest(name = "number \"{0}\" meets the Buzz Rule")
    void shouldReturnTrue_BecauseTheyMeetBuzzRule(Integer number) {
        assertTrue(buzzRule.meets(number));
    }

    @ValueSource(ints = {1, 6, 51, 97})
    @ParameterizedTest(name = "number \"{0}\" does not meet the Buzz Rule")
    void shouldReturnFalse_BecauseTheyDoNotMeetBuzzRule(Integer number) {
        assertFalse(buzzRule.meets(number));
    }

    @Test
    void shouldReturnFizz() {
        assertEquals("Buzz", buzzRule.getNameZZ());
    }
}
