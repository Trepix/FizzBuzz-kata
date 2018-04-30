package io.trepixxx.fizzbuzz;

import io.trepixxx.fizzbuzz.rules.BuzzRule;
import io.trepixxx.fizzbuzz.rules.FizzRule;
import io.trepixxx.fizzbuzz.rules.JazzRule;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CheatSheetGenerator {
    private static final ZzTranslator ZZ_TRANSLATOR = new ZzTranslator(
            new FizzRule(),
            new BuzzRule(),
            new JazzRule()
    );

    static void print() {
        String listToPrintString = IntStream.range(1, 100).boxed()
                .map(ZZ_TRANSLATOR::convert)
                .collect(Collectors.joining(" "));
        System.out.print(listToPrintString);
    }
}
