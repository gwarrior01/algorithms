package BracketsChecker;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BracketsChecker {
    private static Map<Character, Character> bracketsPair = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
    );
    private static Deque<Character> deque = new ArrayDeque<>();

    public static boolean isValidBracketsSequence(String sequence) {
        if (sequence == null || sequence.isEmpty()) throw new IllegalArgumentException("Invalid input parameter");
        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);
            if (bracketsPair.containsKey(ch)) {
                if (deque.isEmpty() || bracketsPair.get(ch) != deque.removeFirst()) {
                    return false;
                }
            } else {
                deque.addFirst(ch);
            }
        }
        return true;
    }
}