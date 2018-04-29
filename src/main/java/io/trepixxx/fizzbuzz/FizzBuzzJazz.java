package io.trepixxx.fizzbuzz;

class FizzBuzzJazz {
    static String convert(Integer number) {
        if (isFizz(number) && isBuzz(number)) return "FizzBuzz";
        if (isFizz(number) && isJazz(number)) return "FizzJazz";
        if (isBuzz(number) && isJazz(number)) return "BuzzJazz";
        if (isFizz(number)) return "Fizz";
        if (isBuzz(number)) return "Buzz";
        if (isJazz(number)) return "Jazz";
        return String.valueOf(number);
    }

    private static boolean isFizz(Integer number) {
        return number % 3 == 0;
    }

    private static boolean isBuzz(Integer number) {
        return number % 5 == 0;
    }

    private static boolean isJazz(Integer number) {
        return number % 7 == 0;
    }

}
