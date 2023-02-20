package src.com.codes.practice.GreedyAlgos;

import java.util.Arrays;

public class StockSpan {

    public static void main(String[] args) {
        int[] stockPrices;
        stockPrices = new int[]{100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(getStockSpan(stockPrices)));
    }

    private static int[] getStockSpan(int[] stockPrices) {
        int[] span = new int[stockPrices.length];
        span[0] = 1;
        for(int i=1;i<stockPrices.length;i++){
            int count = 0;
            for(int j=i;j>=0;j--){
                if(stockPrices[j] <= stockPrices[i])
                    count+=1;
                else
                    break;
            }
            span[i] = count;
        }
        return span;
    }
}
