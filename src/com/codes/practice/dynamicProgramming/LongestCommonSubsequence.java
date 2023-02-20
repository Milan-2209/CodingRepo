package src.com.codes.practice.dynamicProgramming;

import static java.lang.Integer.max;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String st1 = "AGGTAB";
        String st2 = "GXTXAYB";
        int[][] matrix = new int[st2.length()+1][st1.length()+1];
        System.out.println(getLongestCommonSubseq(st1,st2,matrix));//expected 4
    }

    private static int getLongestCommonSubseq(String st1, String st2, int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0)
                    matrix[i][j] = 0;
                else{
                    if(st2.charAt(i - 1) == st1.charAt(j - 1)){
                        matrix[i][j] = matrix[i-1][j-1] + 1;
                    }
                    else{
                        matrix[i][j] = max(matrix[i][j-1],matrix[i-1][j]);
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
        return matrix[st2.length()][st1.length()];
    }
}
