package src.com.codes.practice.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FirstLastPosition {

    private static List<Integer> firsLastPositionOfTarget(Integer[] arr,int target){
        boolean flag = false;
        List<Integer> list = Arrays.asList(arr);
        List<Integer> result = new ArrayList<>();
        Collections.sort(list);
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)==target){
                result.add(i);
                flag = true;
            }
        }
        if (flag)
            return new ArrayList<>(){{add(result.get(0));add(result.get(result.size()-1));}};
        return new ArrayList<>(){{add(-1);add(-1);}};
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,4,1,6,7,6,9,3,6,6};
        System.out.println(firsLastPositionOfTarget(arr,6));
    }
}
