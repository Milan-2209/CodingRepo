package src.com.codes.practice.general;

public class MatrixSpiral {

    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printSpiralMatrix(matrix,matrix.length,matrix[0].length);
    }

    private static void printSpiralMatrix(int[][] matrix, int r, int c) {
        int k=0; int l=0;
        while(k < r && l < c){
            for(int i=l;i<c;i++){
                System.out.print(" "+matrix[k][i]);
            }
            k++;
            for(int i=k;i<r;i++){
                System.out.print(" "+matrix[i][c-1]);
            }
            c--;
            for(int i=c-1;i>=l;i--){
                System.out.print(" "+matrix[r-1][i]);
            }
            r--;
            for(int i=r-1;i>=k;i--){
                System.out.print(" "+matrix[i][l]);
            }
            l++;
        }
    }

}
