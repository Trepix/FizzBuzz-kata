package io.trepixxx.fizzbuzz.rules;

public class BuzzRule extends ZzRule {

    @Override
    public boolean meets(Integer number) {
        return isMultipleOrContains(number, 5);
    }

    @Override
    public String getNameZZ() {
        return "Buzz";
    }
}
