package io.trepixxx.fizzbuzz;

class FizzBuzz {
    static String convert(Integer number) {
        if (number % 3 == 0) return "Fizz";
        return String.valueOf(number);
    }
}
