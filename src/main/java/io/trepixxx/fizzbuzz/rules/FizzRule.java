package io.trepixxx.fizzbuzz.rules;

public class FizzRule extends ZzRule {

    @Override
    public boolean meets(Integer number) {
        return isMultipleOrContains(number, 3);
    }

    @Override
    public String getNameZZ() {
        return "Fizz";
    }
}
