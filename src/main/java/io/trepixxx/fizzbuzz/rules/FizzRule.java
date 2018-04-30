package io.trepixxx.fizzbuzz.rules;

class FizzRule implements ZzRule{

    @Override
    public boolean meets(Integer number) {
        return number % 3 == 0;
    }

    @Override
    public String getNameZZ() {
        return "Fizz";
    }
}
