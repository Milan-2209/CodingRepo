package src.com.codes.practice.dynamicProgramming;

import java.util.Arrays;

import static java.lang.StrictMath.max;
// A Bitonic sequence is a sequence that is combination of an increasing subsequence and
// a decreasing subsequence. We need to find the longest bitonic subsequence for a given sequence
public class LongestBitonicSubseq {

    public static void main(String[] args) {
        int[] seq = new int[]{1,11,2,10,4,5,2,1};
        int[] LisSeq = findLIS(seq);
        System.out.println(Arrays.toString(LisSeq));
        int[] LdsSeq = findLDS(seq);
        System.out.println(Arrays.toString(LdsSeq));
        System.out.println(findLongestBitonicSubSeq(LisSeq,LdsSeq));//expected 6
    }

    private static int findLongestBitonicSubSeq(int[] lisSeq, int[] ldsSeq) {
        int max = lisSeq[0] + ldsSeq[0] - 1;
        for(int i=1;i<lisSeq.length;i++){
            if(lisSeq[i] + ldsSeq[i] - 1 > max)
                max = lisSeq[i] + ldsSeq[i] - 1;
        }
        return max;
    }

    private static int[] findLDS(int[] seq) {
        int[] LDS = new int[seq.length];
        Arrays.fill(LDS, 1);
        for(int i= seq.length-2;i>=0;i--){
            for(int j=seq.length-1;j>i;j--){
                if(seq[j] < seq[i]){
                    LDS[i] = max(LDS[j]+1,LDS[i]);
                }
            }
        }
        return LDS;
    }

    private static int[] findLIS(int[] seq) {
        int[] LIS = new int[seq.length];
        Arrays.fill(LIS,1);
        for(int i=1;i<seq.length;i++){
            for(int j=0;j<i;j++){
                if(seq[j] < seq[i]){
                    LIS[i] = max(LIS[j]+1,LIS[i]);
                }
            }
        }
        return LIS;
    }
}
