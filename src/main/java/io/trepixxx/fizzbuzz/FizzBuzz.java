package io.trepixxx.fizzbuzz;

class FizzBuzz {
    static String convert(Integer number) {
        if (number % 3 == 0) return "Fizz";
        if (number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }
}
