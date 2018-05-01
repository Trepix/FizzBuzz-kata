package io.trepixxx.fizzbuzz.rules;

public class JazzRule extends ZzRule {

    @Override
    public boolean meets(Integer number) {
        return isMultipleOrContains(number, 7);
    }

    @Override
    public String getNameZZ() {
        return "Jazz";
    }
}
