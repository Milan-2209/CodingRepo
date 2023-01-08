package src.com.codes.practice.leetcode_solutions;

import java.util.Scanner;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        int[] list = new int[2];
        for(int i=0;i<nums.length;i++){
            list[0]=i;
            int j;
            for(j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                {
                    list[1]=j;
                    break;
                }
            }
            if(j!=nums.length)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        System.out.println("Enter size of array: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target: ");
        int t = sc.nextInt();
        System.out.println(twoSums.twoSum(arr,t));
    }

}
