package io.trepixxx.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CheatSheetGenerator {
    static void print() {
        String listToPrintString = IntStream.range(1, 100).boxed()
                .map(FizzBuzzJazz::convert)
                .collect(Collectors.joining(" "));
        System.out.print(listToPrintString);
    }
}
