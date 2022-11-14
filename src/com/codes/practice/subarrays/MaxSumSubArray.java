package com.ford.practice.subarrays;

public class MaxSumSubArray {

    private static int maxSumSubarray(int[] arr,int n){
        //using Kadane's algorithm
        int sum = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum < 0)
                sum = 0;
            if(sum > max)
                max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-1,4,2,-6,10,11};
        System.out.println(maxSumSubarray(arr,arr.length));
    }
}
