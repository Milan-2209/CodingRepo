package src.com.codes.practice.dynamicProgramming;

import java.util.Arrays;

public class TilesSelection {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        System.out.println(findPossibleWays(arr,n));
    }

    private static int findPossibleWays(int[] arr, int n) {
        if(arr[n] == -1){
            if(n <= 2)
                arr[n] = n;
            else{
                arr[n] = findPossibleWays(arr,n-1) + findPossibleWays(arr,n-2);
            }
        }
        return arr[n];
    }
}
