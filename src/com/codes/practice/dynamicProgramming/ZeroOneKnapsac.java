package src.com.codes.practice.dynamicProgramming;

import static java.lang.StrictMath.max;

public class ZeroOneKnapsac {

    public static void main(String[] args) {
        int items = 3;
        int[] values = new int[]{60,100,120};
        int[] weights = new int[]{10,20,30};
        int capacity = 50;
        int[][] dp = new int[items+1][capacity+1];
        for (int i=0;i<=items;i++){
            for (int j=0;j<=capacity;j++)
                dp[i][j] = -1;
        }
        System.out.println(findMaxProfitUsingRecursion(values,weights,items,capacity));
        System.out.println(findMaxProfitUsingMemoization(values,weights,items,capacity,dp));
    }

    private static int findMaxProfitUsingRecursion(int[] values, int[] weights, int item, int capacity) {
        if(item==0 || capacity==0)
            return 0;

        else if(weights[item-1] > capacity)
            return findMaxProfitUsingRecursion(values,weights,item-1,capacity);

        else{
            return max((values[item-1] + findMaxProfitUsingRecursion(values, weights, item-1, capacity-weights[item-1])),
                    findMaxProfitUsingRecursion(values, weights, item-1, capacity));
        }
    }

    private static int findMaxProfitUsingMemoization(int[] values, int[] weights, int item, int capacity,int dp[][]) {
        if(item==0 || capacity==0)
            return 0;
        if(dp[item][capacity] != -1)
            return dp[item][capacity];
        else if(weights[item-1] > capacity)
            return dp[item][capacity] = findMaxProfitUsingRecursion(values,weights,item-1,capacity);

        else
            return dp[item][capacity] = max((values[item-1] + findMaxProfitUsingRecursion(values, weights, item-1, capacity-weights[item-1])),
                    findMaxProfitUsingRecursion(values, weights, item-1, capacity));

    }
}
