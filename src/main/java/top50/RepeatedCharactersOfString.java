package top50;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class RepeatedCharactersOfString {

    public static void printRepeatedCharacters(String inputString) {
        Map<Character, Integer> countHolder = new HashMap<>(inputString.length());
        Stream.iterate(0, i -> i + 1)
                .limit(inputString.length())
                .forEach(index -> countHolder.compute(inputString.charAt(index), (k, v) ->
                        Optional.ofNullable(v)
                                .map(value -> Integer.valueOf(value + 1))
                                .orElse(1)
                ));
        countHolder.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(
                        new StringBuilder("character ")
                                .append(entry.getKey())
                                .append(" exists ")
                                .append(entry.getValue())
                                .append(" times").toString()));
    }
}
