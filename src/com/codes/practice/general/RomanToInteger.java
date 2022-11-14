package com.java.myWay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println("Enter Roman String: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution2.romanToInt(str));
    }
}
class Solution2 {
    public int romanToInt(String s) {
        Map<Character,Integer> romanToInteger = new HashMap<>();
        int value = 0;
        romanToInteger.put('I',1);
        romanToInteger.put('V',5);
        romanToInteger.put('X',10);
        romanToInteger.put('L',50);
        romanToInteger.put('C',100);
        romanToInteger.put('D',500);
        romanToInteger.put('M',1000);
        for(int i=0;i<s.length();i++){
            if(i < s.length() - 1) {
                if ((Character.compare(s.charAt(i), 'I') == 0) && (Character.compare(s.charAt(i + 1), 'V') == 0)) {
                    value = value + (romanToInteger.get('V') - romanToInteger.get('I'));
                    ++i;
                }
                else if ((Character.compare(s.charAt(i), 'I') == 0) && (Character.compare(s.charAt(i + 1), 'X') == 0)) {
                    value = value + (romanToInteger.get('X') - romanToInteger.get('I'));
                    ++i;
                }
                else if ((Character.compare(s.charAt(i), 'X') == 0) && (Character.compare(s.charAt(i + 1), 'L') == 0)) {
                    value = value + (romanToInteger.get('L') - romanToInteger.get('X'));
                    ++i;
                }
                else if ((Character.compare(s.charAt(i), 'X') == 0) && (Character.compare(s.charAt(i + 1), 'C') == 0)) {
                    value = value + (romanToInteger.get('C') - romanToInteger.get('X'));
                    ++i;
                }
                else if ((Character.compare(s.charAt(i), 'C') == 0) && (Character.compare(s.charAt(i + 1), 'D') == 0)) {
                    value = value + (romanToInteger.get('D') - romanToInteger.get('C'));
                    ++i;
                }
                else if ((Character.compare(s.charAt(i), 'C') == 0) && (Character.compare(s.charAt(i + 1), 'M') == 0)) {
                    value = value + (romanToInteger.get('M') - romanToInteger.get('C'));
                    ++i;
                }
                else
                    value = value + romanToInteger.get(s.charAt(i));
            }else{
                value = value + romanToInteger.get(s.charAt(i));
            }
        }
        return value;
    }
}
