package src.com.codes.practice.GreedyAlgos;

import java.util.*;

//Given a knapsac with certain capacity W, fill knapsac such that value is maximum and total weight is
//almost W. Items can be broken down to maximise the knapsac value

public class FractionalKnapsac {

    public static void main(String[] args) {
        Item item1 = new Item(10,60);
        item1.setValWeighRatio();
        Item item2 = new Item(20,100);
        item2.setValWeighRatio();
        Item item3 = new Item(30,120);
        item3.setValWeighRatio();
        Map<Item,Integer> items = new HashMap<>(){{
            put(item1,item1.getValWeighRatio());
            put(item2,item2.getValWeighRatio());
            put(item3,item3.getValWeighRatio());
        }};
        int capacity = 20;
        System.out.println("Maximum value received: "+getMaxvalue(items,capacity));

    }

    private static int getMaxvalue(Map<Item, Integer> items,int cap) {
        List<Map.Entry<Item,Integer>> entries = new ArrayList<>(items.entrySet());
        Collections.sort(entries,Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println(entries);
        int maxValue = 0;
        for(Map.Entry<Item,Integer> e: entries){
            if(cap > 0){
                if(e.getKey().getWeight() < cap){
                    maxValue+=e.getKey().getValue();
                    cap-=e.getKey().getWeight();
                }
                else{
                    int valueAdded = (cap * e.getKey().getValue())/e.getKey().getWeight();
                    maxValue+=valueAdded;
                }
            }
        }
         return maxValue;
    }

}



class Item{

    int weight;
    int value;
    int valWeighRatio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValWeighRatio() {
        return valWeighRatio;
    }

    public void setValWeighRatio() {
        this.valWeighRatio = this.value/this.weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                ", valWeighRatio=" + valWeighRatio +
                '}';
    }
}