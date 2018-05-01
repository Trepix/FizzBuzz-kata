package io.trepixxx.fizzbuzz;

import io.trepixxx.fizzbuzz.rules.BuzzRule;
import io.trepixxx.fizzbuzz.rules.FizzRule;
import io.trepixxx.fizzbuzz.rules.JazzRule;
import io.trepixxx.fizzbuzz.rules.ZzRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ZzTranslatorTest {

    private static final Integer NUMBER = 5;
    private ZzTranslator zzTranslator;

    @BeforeEach
    void instanceRule() {
        zzTranslator = new ZzTranslator(
                new FizzRule(),
                new BuzzRule(),
                new JazzRule()
        );
    }

    @Test
    void givenNoRules_ReturnNumberAsString() {
        ZzTranslator zzTranslator = new ZzTranslator();
        assertEquals(NUMBER.toString(), zzTranslator.convert(NUMBER));
    }

    @Test
    void givenOnlyOneRuleWhichIsAlwaysTrue_ShouldReturnsItsTranslation() {
        String zzRule = "RuleZZ";
        ZzRule rule = mock(ZzRule.class);
        when(rule.meets(NUMBER)).thenReturn(true);
        when(rule.getNameZZ()).thenReturn(zzRule);

        ZzTranslator zzTranslator = new ZzTranslator(rule);
        assertEquals(zzRule, zzTranslator.convert(NUMBER));
    }

    @Test
    void givenOnlyOneRuleWhichIsAlwaysFalse_ShouldReturnsNumberAsString() {
        ZzRule rule = mock(ZzRule.class);
        when(rule.meets(NUMBER)).thenReturn(false);

        ZzTranslator zzTranslator = new ZzTranslator(rule);
        assertEquals(NUMBER.toString(), zzTranslator.convert(NUMBER));
    }

    @ValueSource(ints = {3, 6, 33, 99})
    @ParameterizedTest(name = "number \"{0}\" is converted to Fizz")
    void givenFizzButNotBuzzNorJazzNumber_ThenReturnFizz(Integer number) {
        assertEquals("Fizz", zzTranslator.convert(number));
    }

    @ValueSource(ints = {5, 10, 50, 95})
    @ParameterizedTest(name = "number \"{0}\" is converted to Buzz")
    void givenBuzzButNotFizzNorJazzNumber_ThenReturnBuzz(Integer number) {
        assertEquals("Buzz", zzTranslator.convert(number));
    }

    @ValueSource(ints = {7, 14, 49, 98})
    @ParameterizedTest(name = "number \"{0}\" is converted to Jazz")
    void givenJazzButNotFizzNorBuzzNumber_ThenReturnJazz(Integer number) {
        assertEquals("Jazz", zzTranslator.convert(number));
    }

    @ValueSource(ints = {15, 30, 45, 90})
    @ParameterizedTest(name = "number \"{0}\" is converted to FizzBuzz")
    void givenFizzBuzzNumberButNotJazz_ThenReturnFizzBuzz(Integer number) {
        assertEquals("FizzBuzz", zzTranslator.convert(number));
    }

    @ValueSource(ints = {21, 42, 63})
    @ParameterizedTest(name = "number \"{0}\" is converted to FizzJazz")
    void givenFizzJazzButNotBuzzNumber_ThenReturnFizzJazz(Integer number) {
        assertEquals("FizzJazz", zzTranslator.convert(number));
    }

    @ValueSource(ints = {35, 70})
    @ParameterizedTest(name = "number \"{0}\" is converted to BuzzJazz")
    void givenBuzzJazzButNotFizzNumber_ThenReturnBuzzJazz(Integer number) {
        assertEquals("BuzzJazz", zzTranslator.convert(number));
    }
}
