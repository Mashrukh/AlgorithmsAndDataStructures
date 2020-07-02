package Strings;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        char[] chrs = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        int count = 0;

        if (s.length() < 3) {
            return true;
        }

        while (start <= end) {
            if (chrs[start] != chrs[end]) {
                return palindromeCheck(chrs, start, end - 1) || palindromeCheck(chrs, start + 1, end);
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean palindromeCheck(char[] chrs, int start, int end) {
        while (start <= end) {
            if (chrs[start] != chrs[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
