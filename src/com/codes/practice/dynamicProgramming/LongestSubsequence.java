package src.com.codes.practice.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.max;

public class LongestSubsequence {

    public static void main(String[] args) {
        int[] sequence;sequence = new int[]{10,22,9,33,21,50,41,60};
        int[] LIS = new int[sequence.length];
        for(int i=0;i<LIS.length;i++){
            LIS[i] = 1;
        }

        System.out.println(longestSubsequence(sequence,LIS));//expected 5
    }

    private static int longestSubsequence(int[] sequence, int[] LIS) {
        for(int i=1;i<sequence.length;i++){
            for(int j=0;j<i;j++){
                if(sequence[i] > sequence[j]){
                    LIS[i] = max(LIS[j]+1,LIS[i]);
                }
            }
        }
        System.out.println(Arrays.toString(LIS));
        return Arrays.stream(LIS).max().getAsInt();
    }




}
