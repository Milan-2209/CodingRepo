package src.com.codes.practice.GreedyAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockBuySell {

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{100,180,260,310,40,535,695};
        List<Stock> stockList = findStockBuySellValue(arr,arr.length);
        System.out.println(stockList);
    }

    private static List<Stock> findStockBuySellValue(int[] arr,int n) {
        int minima = -1;
        int maxima = -1;
        int j = 0;
        Map<Integer,Integer> visited = new HashMap<>();
        for(int i=0;i<n;i++){
            visited.put(arr[i],0);
        }
        List<Stock> stocks = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(arr[i] < arr[i+1] && visited.get(arr[i]) == 0){
                minima = arr[i];
                visited.put(arr[i],1);
            }

            if(minima > 0){
                for(j=i+1;j<n-1;j++){
                    visited.put(arr[j],1);
                    if(arr[j] > arr[j+1]){
                        maxima = arr[j];
                        break;
                    }

                }
            }
            if(j==n-1)
                maxima = arr[n-1];
            if(minima > 0 && maxima > 0)
                stocks.add(new Stock(minima,maxima));
            minima = -1;
            maxima = -1;
        }
        return stocks;

    }
}

class Stock{
    int buy;
    int sell;

    public Stock(int but, int sell) {
        this.buy = but;
        this.sell = sell;
    }

    public int getBut() {
        return buy;
    }

    public void setBut(int but) {
        this.buy = but;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "buyValue=" + buy +
                ", sellValue=" + sell +
                '}';
    }
}
