package io.trepixxx.fizzbuzz.rules;

class BuzzRule implements ZzRule{

    @Override
    public boolean meets(Integer number) {
        return number % 5 == 0;
    }

    @Override
    public String getNameZZ() {
        return "Buzz";
    }
}
