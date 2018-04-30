package io.trepixxx.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CheatSheetGenerator {
    private static final ZzTranslator ZZ_TRANSLATOR = new ZzTranslator();

    static void print() {
        String listToPrintString = IntStream.range(1, 100).boxed()
                .map(ZZ_TRANSLATOR::convert)
                .collect(Collectors.joining(" "));
        System.out.print(listToPrintString);
    }
}
