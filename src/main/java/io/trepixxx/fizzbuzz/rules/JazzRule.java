package io.trepixxx.fizzbuzz.rules;

public class JazzRule implements ZzRule {

    @Override
    public boolean meets(Integer number) {
        return number % 7 == 0;
    }

    @Override
    public String getNameZZ() {
        return "Jazz";
    }
}
