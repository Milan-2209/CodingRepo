package src.com.codes.practice.dynamicProgramming;

import static java.lang.StrictMath.min;

//Finding the value for nCr
public class BinomialCoefficient {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int[][] c = new int[n+1][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                c[i][j] = -1;
            }
        }
        System.out.println(findBinCoWithRecursion(n,k));//expected 6
        System.out.println(findBinCoWithIterativeDP(c,n,k));//expected 6
    }

    private static int findBinCoWithRecursion(int n, int k) {
        if(n==k || k==0)
            return 1;
        else
            return findBinCoWithRecursion(n-1,k-1) + findBinCoWithRecursion(n-1,k);
    }

    private static int findBinCoWithIterativeDP(int[][] c, int n, int k) {
        for(int i=0;i<=n;i++){
            for(int j=0;j<=min(i,k);j++){
                if(i==j || j==0)
                    c[i][j] = 1;
                else
                    c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        return c[n][k];
    }
}
