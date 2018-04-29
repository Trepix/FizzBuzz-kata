package io.trepixxx.fizzbuzz;

class FizzBuzz {
    static String convert(Integer number) {
        if (isFizz(number) && isBuzz(number)) return "FizzBuzz";
        if (isFizz(number)) return "Fizz";
        if (isBuzz(number)) return "Buzz";
        return String.valueOf(number);
    }

    private static boolean isFizz(Integer number) {
        return number % 3 == 0;
    }

    private static boolean isBuzz(Integer number) {
        return number % 5 == 0;
    }

}
