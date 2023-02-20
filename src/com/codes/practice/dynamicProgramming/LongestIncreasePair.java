package src.com.codes.practice.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.StrictMath.max;

public class LongestIncreasePair {

    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>(){{
            add(new ArrayList<>(){{add(5);add(24);}});
            add(new ArrayList<>(){{add(15);add(25);}});
            add(new ArrayList<>(){{add(27);add(40);}});
            add(new ArrayList<>(){{add(50);add(60);}});
        }
        };
        System.out.println(findLongestPair(inputList));
    }

    private static int findLongestPair(List<List<Integer>> inputList) {
        Integer[] LPS = new Integer[inputList.size()];
        Arrays.fill(LPS,1);
        for(int i=1;i<LPS.length;i++){
            for(int j=0;j<i;j++){
                if(inputList.get(i).get(0) > inputList.get(j).get(1))
                    LPS[i] = max(LPS[j]+1,LPS[i]);
            }
        }
        System.out.println(Arrays.toString(LPS));
        return Collections.max(Arrays.asList(LPS));
    }
}
