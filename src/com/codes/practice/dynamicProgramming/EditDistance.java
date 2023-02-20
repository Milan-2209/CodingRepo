package src.com.codes.practice.dynamicProgramming;

//Find the minimum number of modifications needed to be done to convert a string s1 to string s2
public class EditDistance {

    public static void main(String[] args) {
        String s1 = "CART";
        String s2 = "MARCH";
        int[][] matrix = new int[s1.length()+1][s2.length()+1];
        System.out.println(findMinModifiaction(s1,s2,matrix));//expected: 3
    }

    private static int findMinModifiaction(String s1, String s2, int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i == 0)
                    matrix[i][j] = j;
                else if(j == 0)
                    matrix[i][j] = i;
                else{
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        matrix[i][j] = matrix[i-1][j-1];
                    }
                    else{
                        int min = min(matrix[i][j-1],matrix[i-1][j-1],matrix[i-1][j]);
                        matrix[i][j] = min + 1;
                    }
                }

            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
        return matrix[s1.length()][s2.length()];
    }

    private static int min(int a, int b, int c) {
        if(a < b){
            if(a < c)
                return a;
            else
                return c;
        }
        else{
            if(b < c)
                return b;
            else
                return c;
        }
    }
}
