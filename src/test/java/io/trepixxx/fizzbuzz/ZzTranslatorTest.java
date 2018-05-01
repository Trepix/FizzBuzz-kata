package io.trepixxx.fizzbuzz;

import io.trepixxx.fizzbuzz.rules.BuzzRule;
import io.trepixxx.fizzbuzz.rules.FizzRule;
import io.trepixxx.fizzbuzz.rules.JazzRule;
import io.trepixxx.fizzbuzz.rules.ZzRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ZzTranslatorTest {

    private ZzTranslator zzTranslator;

    @BeforeEach
    void instanceRule() {
        zzTranslator = new ZzTranslator(
                new FizzRule(),
                new BuzzRule(),
                new JazzRule()
        );
    }

    @ValueSource(ints = {1, 3, 5, 10, 90})
    @ParameterizedTest(name = "number \"{0}\" is converted to {0} because no rules are provided")
    void givenNoRules_ReturnNumberAsString(Integer number) {
        ZzTranslator zzTranslator = new ZzTranslator();
        assertEquals(number.toString(), zzTranslator.convert(number));
    }

    @ValueSource(ints = {3, 50, 99})
    @ParameterizedTest(name = "number \"{0}\" is translated because rule is forced to true")
    void givenOnlyOneRuleWhichIsAlwaysTrue_ShouldReturnsItsTranslation(Integer number) {
        String zzRule = "RuleZZ";
        ZzRule rule = mock(ZzRule.class);
        when(rule.meets(number)).thenReturn(true);
        when(rule.getNameZZ()).thenReturn(zzRule);

        ZzTranslator zzTranslator = new ZzTranslator(rule);
        assertEquals(zzRule, zzTranslator.convert(number));
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
