package designpatterns.strategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CamelCaseFormatter implements TextFormatter {
    @Override
    public String format(String input) {
        String[] words = input.split(" ");
        String output = IntStream.range(0, words.length)
                .mapToObj(i -> {
                    String word = words[i].toLowerCase();
                    if (i == 0) return word;
                    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
                })
                .collect(Collectors.joining());
        return "CamelCaseFormatter: "+output;
    }
}