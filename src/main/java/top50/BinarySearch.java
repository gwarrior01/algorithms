package top50;

public class BinarySearch {

    public static int binarySearch(int[] array, int key) {
        if (array.length == 0) return -1;
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (array[med] == key) {
                return med;
            } else if (array[med] > key) {
                high = med - 1;
            } else {
                low = med + 1;
            }
        }
        return -1;
    }
}