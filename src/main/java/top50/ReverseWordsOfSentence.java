package top50;

public class ReverseWordsOfSentence {

    private static final String WORDS_SEPARATOR = " ";

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(WORDS_SEPARATOR);
        if (words.length < 2) return sentence;
        for (int index = 0; index < words.length / 2; index++) {
            reverseArrayElement(words, index);
        }
        return String.join(WORDS_SEPARATOR, words);
    }

    private static String[] reverseArrayElement(String[] inputArray, int reversedIndex) {
        return swapArrayElements(inputArray, reversedIndex, inputArray.length - 1 - reversedIndex);
    }

    private static String[] swapArrayElements(String[] inputArray, int oneElementPosition, int secondElementPosition) {
        String tmp = inputArray[oneElementPosition];
        inputArray[oneElementPosition] = inputArray[secondElementPosition];
        inputArray[secondElementPosition] = tmp;
        return inputArray;
    }

}
