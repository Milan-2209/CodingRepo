package com.ford.practice.subarrays;

import java.util.Arrays;

//Sum of any two elements of subarray is equal to particular value(k)
public class SumOfTwoNumsSubarray {

    private static boolean sumOfElements(int[] arr,int n,int k){
        int low = 0;
        int high = n-1;
        while(low < high){
            if(arr[low] + arr[high] == k)
                return true;

            if(arr[low] + arr[high] < k)
                low++;

            if(arr[low] + arr[high] > k)
                high--;

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,11,7,21,14,16,20};
        Arrays.sort(arr);
        if(sumOfElements(arr,arr.length,71))
            System.out.println("Sum exists");
        else
            System.out.println("Sum does not exist");
    }
}
