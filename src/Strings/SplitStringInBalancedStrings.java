package Strings;

public class SplitStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int lCtr = 0;
        int rCtr = 0;
        int matches = 0;
        char[] chrs = s.toCharArray();

        for (char c : chrs) {
            if (c == 'L') {
                lCtr++;
            }
            if (c == 'R') {
                rCtr++;
            }

            if (lCtr == rCtr && lCtr != 0) {
                matches++;
                lCtr = 0;
                rCtr = 0;
            }
        }
        return matches;
    }
}
