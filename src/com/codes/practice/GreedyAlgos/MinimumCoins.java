package src.com.codes.practice.GreedyAlgos;

//Given an amount find out how many minimum number of coins is required
//to get that value with a given set of coin values

public class MinimumCoins {

    public static void main(String[] args) {
        int value = 2000;
        System.out.println("Minimum coins required: "+findMinCoins(value));
    }

    private static int findMinCoins(int value) {
        int[] currency;
        int coinsReq = 0;
        currency = new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000};
        for(int i=currency.length-1;i>=0;i--){
            while (value > 0){
                if(currency[i] <= value){
                    System.out.println(currency[i]);
                    value-=currency[i];
                    coinsReq+=1;
                }
                else
                    break;
            }
        }
        return coinsReq;
    }
}
