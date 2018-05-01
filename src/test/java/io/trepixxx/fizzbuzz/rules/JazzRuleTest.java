package io.trepixxx.fizzbuzz.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class JazzRuleTest {

    private ZzRule jazzRule;

    @BeforeEach
    void instanceRule() {
        jazzRule = new JazzRule();
    }

    @ValueSource(ints = {7, 14, 49, 98})
    @ParameterizedTest(name = "number \"{0}\" meets the Jazz Rule because it's multiple of 7")
    void shouldReturnTrue_BecauseTheyMeetBuzzRule(Integer number) {
        assertTrue(jazzRule.meets(number));
    }

    @ValueSource(ints = {7, 17, 57, 76, 97})
    @ParameterizedTest(name = "number \"{0}\" meets the Jazz Rule because it contains a 7")
    void shouldReturnTrue_BecauseTheyContainAThreeDigit(Integer number) {
        assertTrue(jazzRule.meets(number));
    }

    @ValueSource(ints = {1, 8, 69, 81, 99})
    @ParameterizedTest(name = "number \"{0}\" does not meet the Jazz Rule")
    void shouldReturnFalse_BecauseTheyDoNotMeetBuzzRule(Integer number) {
        assertFalse(jazzRule.meets(number));
    }

    @Test
    void shouldReturnJazz() {
        assertEquals("Jazz", jazzRule.getNameZZ());
    }
}
