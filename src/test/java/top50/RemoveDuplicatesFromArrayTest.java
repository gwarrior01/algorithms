package top50;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RemoveDuplicatesFromArrayTest {

    @Test
    void removeDuplicateFromIntArray() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, RemoveDuplicatesFromArray.removeDuplicateFromIntArray(new int[]{1, 3, 5, 6, 6, 2, 2, 3, 4}));
    }

    @Test
    void removeDuplicateFromCharArray() {
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, RemoveDuplicatesFromArray.removeDuplicateFromCharArray(new char[]{'a', 'b', 'c', 'd', 'b'}));
    }

    @Test
    void removeDuplicateFromStringArray() {
        assertArrayEquals(new String[]{"a", "abc", "bcd"}, RemoveDuplicatesFromArray.removeDuplicateFromStringArray(new String[]{"abc", "a", "bcd", "abc", "a"}));
    }

    @Test
    void removeDuplicateFromArray() {
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, RemoveDuplicatesFromArray.removeDuplicateFromArray(new Integer[]{1, 3, 5, 6, 6, 2, 2, 3, 4}, Integer.class, (a, b) -> a != b));
        assertArrayEquals(new Character[]{'a', 'b', 'c', 'd'}, RemoveDuplicatesFromArray.removeDuplicateFromArray(new Character[]{'a', 'b', 'c', 'd', 'b'}, Character.class, (a, b) -> a != b));
        assertArrayEquals(new String[]{"a", "abc", "bcd"}, RemoveDuplicatesFromArray.removeDuplicateFromArray(new String[]{"abc", "a", "bcd", "abc", "a"}, String.class, (a, b) -> !a.equals(b)));
    }
}