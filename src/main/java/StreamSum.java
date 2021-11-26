import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamSum {
    public static void main(String[] args) {
        Map<Boolean, Integer> result = Arrays.asList(1, 2, 3, -9, 10, 4, -8, -6, 6).stream()
                .map(number -> Map.of(number > 0, number))
                .reduce(
                        Arrays.asList(true, false).stream().collect(Collectors.toMap(Function.identity(), i -> 0)),
                        (accumMap, map) -> {
                            Integer number = Optional.ofNullable(map.get(true)).orElse(map.get(false));
                            accumMap.merge(number > 0, map.get(number > 0), (prev, value) -> prev + value);
                            return accumMap;
                        }
                );
        System.out.println(result);
    }
}
