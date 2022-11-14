package com.java.myWay;

import java.util.*;

public class ReversePairs {
    public static void main(String[] args) {
        int nums[] = new int[5];
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> rMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(nums);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            //System.out.println(a);
            for(int j=i+1;j<nums.length;j++){
                if(a > 2*nums[j]){
                    count+=1;
                    rMap.put(a,nums[j]);
                }
            }
        }
        System.out.println("Number of possible pairs: "+count);
        System.out.println("The pairs are: ");
        System.out.println(rMap);
    }


}
