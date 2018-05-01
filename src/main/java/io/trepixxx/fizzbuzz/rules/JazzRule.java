package io.trepixxx.fizzbuzz.rules;

public class JazzRule extends ZzRule {

    @Override
    public boolean meets(Integer number) {
        return number % 7 == 0;
    }

    @Override
    public String getNameZZ() {
        return "Jazz";
    }
}
