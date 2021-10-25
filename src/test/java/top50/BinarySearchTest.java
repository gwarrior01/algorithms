package top50;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Бинарный поиск")
class BinarySearchTest {
    private static final int NOT_FOUND_INDEX = -1;
    private static final int ZERO_INDEX = 0;
    private static final int CORRECT_INDEX = 4;

    @Test
    @DisplayName(" на пустом массиве должен возвращать -1")
    void shouldReturnNotFoundIndexOnEmptyArray() {
        assertThat(BinarySearch.binarySearch(new int[]{}, 3))
                .isEqualTo(NOT_FOUND_INDEX);
    }

    @Test
    @DisplayName(" на массиве размером 1 должен возвращать 0, если массив содержит требуемый элемент")
    void shouldReturnZeroIndexOnArrayWithOneRequiredElement() {
        assertThat(BinarySearch.binarySearch(new int[]{1}, 1))
                .isEqualTo(ZERO_INDEX);
    }

    @Test
    @DisplayName(" на массиве размером 1 должен возвращать -1, если массив не содержит требуемый элемент")
    void shouldReturnNotFoundIndexOnArrayWithOneNotRequiredElement() {
        assertThat(BinarySearch.binarySearch(new int[]{1}, 2))
                .isEqualTo(NOT_FOUND_INDEX);
    }

    @Test
    @DisplayName(" должен возвращать индекс, если массив содержит требуемый элемент")
    void shouldReturnCorrectIndexOnArrayWithRequiredElement() {
        assertThat(BinarySearch.binarySearch(new int[]{1, 2, 4, 7, 8, 10, 34, 67}, 8))
                .isEqualTo(CORRECT_INDEX);
    }

    @Test
    @DisplayName(" должен возвращать -1, если массив не содержит требуемый элемент")
    void shouldReturnNotFoundIndexOnArrayWithoutRequiredElement() {
        assertThat(BinarySearch.binarySearch(new int[]{1, 2, 4, 7, 8, 10, 34, 67}, 5))
                .isEqualTo(NOT_FOUND_INDEX);
    }
}