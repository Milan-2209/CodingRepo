package src.com.codes.practice.dynamicProgramming;

import static java.lang.StrictMath.max;

public class EggDropping {

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 4;
        int[][] dp = new int[eggs][floors];
        for (int i=1;i<=eggs;i++){
            for (int j=1;j<=floors;j++)
                dp[i][j] = -1;
        }
        System.out.println(findNumberOfTrialsUsingRecursion(eggs,floors));
    }

    private static int findNumberOfTrialsUsingRecursion(int eggs, int floors) {

        if(floors <= 1)
            return floors;
        else if(eggs == 1)
            return floors;

        int min = 1000000000, res;
        for(int x=1;x<=floors;x++){
            res = max((findNumberOfTrialsUsingRecursion(eggs-1,x-1)),
                    findNumberOfTrialsUsingRecursion(eggs,floors-x));
            if(res < min)
                min = res;
        }
        return min + 1;
    }

//    private static int findNumberOfTrialsUsingDP(int eggs, int floors) {
//        if(dp[eggs][floors] != -1)
//            return dp[eggs][floors];
//
//        int min = 1000000000, res;
//        for(int i=1;i<=eggs;i++){
//            for(int j=1;j<=floors;j++){
//                if(i == 1 || j==1)
//                    dp[i][j] = j;
//                else{
//                    res = max();
//                    if(res < min) {
//                        min = res;
//                        dp[i][j] = 1 + min;
//                    }
//                }
//            }
//        }
//    }
}
