package com.ford.practice.general;

import java.util.*;

public class AnagramCheck {

    private static boolean checkIfAnagram(String s1, String s2){
        boolean flag = false;

        if(s1.length()!=s2.length())
            return flag;
        List<Character> st1 = new ArrayList<>();
        List<Character> st2 = new ArrayList<>();
        for (int i=0;i<s1.length();i++){
            st1.add(s1.charAt(i));
        }
        for (int i=0;i<s2.length();i++){
            st2.add(s2.charAt(i));
        }
        Collections.sort(st1);
        Collections.sort(st2);
//        System.out.println(st1);
//        System.out.println(st2);
        for(int j=0;j<s1.length();j++){
            if(st1.get(j)==st2.get(j))
                flag = true;
            else
                flag = false;
        }
        return flag;

    }


    private static int frequencyChar(String s,char c) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c)
                count+=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(checkIfAnagram("dangger","garden"));
    }
}
