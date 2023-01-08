package src.com.codes.practice.leetcode_solutions;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 24;
        System.out.println(convertIntToRoman(num));
    }

    private static String convertIntToRoman(int num) {
        Map<Integer,String> intToRom = new HashMap<>();
        intToRom.put(1,"I");
        intToRom.put(5,"V");
        intToRom.put(10,"X");
        intToRom.put(50,"L");
        intToRom.put(100,"C");
        intToRom.put(500,"D");
        intToRom.put(1000,"M");
        if(num <= 5){
            if(num == 4)
                return "IV";

        }
        if(num > 5 && num <= 10){

        }
        if(num > 10 && num <= 50){

        }
        if(num > 50 && num <= 100){

        }
        if(num > 100 && num <= 500){

        }
        if(num > 500 && num <= 1000){

        }
        return  "";

    }
}
