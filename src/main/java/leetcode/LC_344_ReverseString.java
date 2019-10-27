package leetcode;

public class LC_344_ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            switchChar(s, left, right);
            left++;
            right--;
        }
    }

    private void switchChar(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

}
