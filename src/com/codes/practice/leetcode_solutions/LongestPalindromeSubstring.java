package src.com.codes.practice.leetcode_solutions;

import java.util.Scanner;

public class LongestPalindromeSubstring {

    public static int checkPalindrome(String s){
        int last = s.length()-1;
        int flag=0;
        if(s.length()<=1)
            return 1;
        for(int i=0;i<s.length()/2;i++){
            if(Character.compare(s.charAt(i),s.charAt(last))==0){
                last--;
                flag=1;
            }
            else{
                flag=0;
                break;
            }
        }
        return flag;

    }
    public String longestPalindrome(String s) {
        String st;
        String longestPali="";
        for(int i=0;i<s.length();i++) {
            int j;
            for (j = s.length()-1; j >= i; j--) {
                st = s.substring(i, j+1);
                if (checkPalindrome(st) == 1  && (st.length() > longestPali.length())) {
                    longestPali = st;
                }
            }
        }
        if(longestPali=="")
            longestPali = Character.toString(s.charAt(0));
        return longestPali;
    }

    public String longestPalindrome2(String s) {
        String st;
        String longestPali="";
        for(int i=0;i<s.length();i++) {
            int j;
            for (j = s.length()-1; j >= i; j--) {
                st = s.substring(i, j+1);
                if (checkPalindrome(st) == 1 && (st.length() > longestPali.length())) {
                    longestPali = st;
                    break;
                }
            }
        }
        if(longestPali=="")
            longestPali = Character.toString(s.charAt(0));
        return longestPali;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LongestPalindromeSubstring lg = new LongestPalindromeSubstring();
        System.out.println("Enter String: ");
        String s = sc.next();
        System.out.println(lg.longestPalindrome2(s));
    }
}
