package io.trepixxx.fizzbuzz.rules;

import static java.lang.String.valueOf;

public abstract class ZzRule {

    public abstract boolean meets(Integer number);

    public abstract String getNameZZ();

    static boolean isMultipleOrContains(Integer number, Integer multipleOrContent) {
        return number % multipleOrContent == 0 || valueOf(number).contains(multipleOrContent.toString());
    }
}
