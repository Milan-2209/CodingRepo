package src.com.codes.practice.dynamicProgramming;

public class LargestSumContiguousArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        System.out.println(kadaneAlgorithm(arr));
    }

    private static int kadaneAlgorithm(int[] arr) {
        int currSum = 0, finalSum = 0;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum < 0){
                currSum = 0;
            }
            else if(currSum > finalSum)
                finalSum = currSum;
        }

        return finalSum;
    }
}
