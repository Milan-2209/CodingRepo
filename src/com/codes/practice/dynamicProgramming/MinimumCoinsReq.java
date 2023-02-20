package src.com.codes.practice.dynamicProgramming;

public class MinimumCoinsReq {

    public static void main(String[] args) {
        int[] coins = new int[]{9,6,5,1};
        int value = 11;
        System.out.println(findMinCoinsRecursively(coins,value));
        System.out.println(findMinCoinsDP(coins,value));
    }

    private static int findMinCoinsDP(int[] coins, int value) {
        int[] table = new int[value+1];
        table[0] = 0;
        for(int i=1;i<=value;i++){
            table[i] = Integer.MAX_VALUE;
        }

        for(int i=1;i<=value;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j] <= i){
                    int subRes = table[i-coins[j]];
                    if(subRes != Integer.MAX_VALUE && 1 + subRes < table[i])
                        table[i] = 1 + subRes;
                }
            }
        }
        return table[value];
    }

    private static int findMinCoinsRecursively(int[] coins, int value) {
        int res = Integer.MAX_VALUE;
        if(value == 0)
            return 0;

        for(int i=0;i<coins.length;i++){
            if(coins[i] <= value){
                int subRes = findMinCoinsRecursively(coins,value-coins[i]);
                if(subRes != Integer.MAX_VALUE && 1 + subRes < res)
                    res = 1 + subRes;
            }
        }
        return res;
    }


}
