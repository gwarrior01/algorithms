package BracketsChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsCheckerTest {

    @Test
    @DisplayName("Check valid sequence of brackets")
    void isValidBracketsSequence() {
        String validSeq = "({})[()]{()}[]";

        assertTrue(BracketsChecker.isValidBracketsSequence(validSeq));
    }

    @Test
    @DisplayName("Check invalid sequence of brackets")
    void isNotValidBracketsSequence() {
        String invalidSeq = "({})[)]{(}[]";

        assertFalse(BracketsChecker.isValidBracketsSequence(invalidSeq));
    }
}