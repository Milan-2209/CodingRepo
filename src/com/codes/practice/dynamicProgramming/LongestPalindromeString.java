package src.com.codes.practice.dynamicProgramming;

import static java.lang.StrictMath.max;

public class LongestPalindromeString {

    public static void main(String[] args) {
        String s = "BABCBAB";
        System.out.println(lps(s.toCharArray(),0,s.length()-1));//expected 7
    }
    private static int lps(char seq[], int i, int j)
    {
        // Base Case 1: If there is only 1 character
        if (i == j) {
            return 1;
        }

        // Base Case 2: If there are only 2 characters and
        // both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }

        // If the first and last characters match
        if (seq[i] == seq[j]) {
            return lps(seq, i + 1, j - 1) + 2;
        }

        // If the first and last characters do not match
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }
}
