package leetcode;

import java.util.Arrays;
import java.util.List;

public class LC_345_ReverseVowelsOfAString {

    //    private Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u');

    // for leetcode submit
    private List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (isVowels(chars[left]) && isVowels(chars[right])) {
                switchChar(chars, left, right);
                left++;
                right--;
            }
            if (!isVowels(chars[left])) {
                left++;
            }
            if (!isVowels(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }

    private boolean isVowels(char s) {
        return vowels.contains(s);
    }

    private void switchChar(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
