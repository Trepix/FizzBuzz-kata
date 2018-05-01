package io.trepixxx.fizzbuzz.rules;

public class FizzRule implements ZzRule {

    @Override
    public boolean meets(Integer number) {
        return (number % 3 == 0) || String.valueOf(number).contains(String.valueOf(3));
    }

    @Override
    public String getNameZZ() {
        return "Fizz";
    }
}
