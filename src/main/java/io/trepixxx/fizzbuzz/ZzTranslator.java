package io.trepixxx.fizzbuzz;

import io.trepixxx.fizzbuzz.rules.ZzRule;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

class ZzTranslator {

    private final List<ZzRule> rules;

    ZzTranslator(ZzRule... rules) {
        this.rules = asList(rules);
    }

    String convert(Integer number) {
        return Optional.of(
                rules.stream()
                        .filter(rule -> rule.meets(number))
                        .map(ZzRule::getNameZZ)
                        .collect(joining())
        ).filter(s -> !s.isEmpty())
        .orElse(String.valueOf(number));
    }
}
