import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamSum {
    public static void main(String[] args) {
        Map<Boolean, Integer> result = Arrays.asList(11, 1, 2, 3, -9, 10, 4, -8, -6, 6, -7).stream()
                .map(number -> Map.of(number > 0, number))
                .reduce(
                        new HashMap<>(Map.of(true, 0, false, 0)),
                        (accumMap, map) -> {
                            Optional.ofNullable(map.get(true))
                                    .ifPresentOrElse(
                                            number -> accumMap.merge(true, map.get(true), (prev, value) -> prev + value),
                                            () -> accumMap.merge(false, map.get(false), (prev, value) -> prev + value)
                                    );
                            return accumMap;
                        }
                );
        System.out.println(result);
    }
}
