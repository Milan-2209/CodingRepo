package src.com.codes.practice.leetcode_solutions;

public class PalindromeNumber {

    public static void main(String[] args) {
        int a = 121;
        System.out.println(checkPalindrome(a));
    }

    private static boolean checkPalindrome(int a) {
        int temp = a;
        int rev = 0;
        while(temp > 0){
            rev = rev * 10 + temp%10;
            temp/=10;
        }
        if(rev == a)
            return true;
        return false;
    }
}
