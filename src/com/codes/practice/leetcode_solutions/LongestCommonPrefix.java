package src.com.codes.practice.leetcode_solutions;

import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        String[] string = new String[size];
        for(int i=0;i<size;i++){
           string[i] = sc.next();
        }
        String st = solution.longestCommonPrefix(string);
        System.out.println(st);
    }


}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int max = 10000;
        String str = "";
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<max){
                max = strs[i].length();
                str = strs[i];
            }
        }
        StringBuilder st = new StringBuilder(str);
        for(int i=st.length()-1;i>=0;i--){
            int j;
            for(j=0;j<strs.length;j++){
                if(strs[j].startsWith(st.toString()))
                    continue;
                else
                    break;
            }
            if(j==strs.length)
                return st.toString();
            else
                st=st.deleteCharAt(i);
        }
        return "";
    }
}