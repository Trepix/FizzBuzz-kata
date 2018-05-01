package io.trepixxx.fizzbuzz;

import io.trepixxx.fizzbuzz.rules.ZzRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ZzTranslatorTest {

    private static final Integer NUMBER = 5;

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

    @Test
    void givenMultipleRules_ShouldReturnsTheTranslationOfOnlyMetRules() {
        String abcTranslation = "abc";
        String xyzTranslation = "xyz";

        ZzRule abcMetRule = mock(ZzRule.class);
        when(abcMetRule.meets(NUMBER)).thenReturn(true);
        when(abcMetRule.getNameZZ()).thenReturn(abcTranslation);

        ZzRule xyzMetRule = mock(ZzRule.class);
        when(xyzMetRule.meets(NUMBER)).thenReturn(true);
        when(xyzMetRule.getNameZZ()).thenReturn(xyzTranslation);

        ZzRule notMetRule = mock(ZzRule.class);
        when(notMetRule.meets(NUMBER)).thenReturn(false);

        ZzTranslator zzTranslator = new ZzTranslator(abcMetRule, notMetRule, xyzMetRule);
        assertEquals(abcTranslation + xyzTranslation, zzTranslator.convert(NUMBER));
    }
}
