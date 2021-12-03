package top50;

public class FirstUnrepeatableCharacter {

    public static char getFirstUnrepeatableChar(String value) {
        int[] arr = new int[256];
        for (int i = 0; i < value.length(); i++) {
            char c = Character.toLowerCase(value.charAt(i));
            arr[c] = arr[c] + 1;
        }
        for (int i = 0; i < value.length(); i++) {
            char c = Character.toLowerCase(value.charAt(i));
            if (arr[c] == 1) {
                return value.charAt(i);
            }
        }
        return ' ';
    }
}
