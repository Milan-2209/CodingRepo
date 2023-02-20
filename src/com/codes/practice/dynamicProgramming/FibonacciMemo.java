package src.com.codes.practice.dynamicProgramming;

//using the dynamic programming memoization technique to find the nth fibonacci number
public class FibonacciMemo {

    public static void main(String[] args) {
        int n = 5;
        int[] table = new int[n+1];
        for(int i=0;i<table.length;i++){
            table[i] = -1;
        }
        System.out.println(fibonacci(n,table));//expected 5
    }

    private static int fibonacci(int n, int[] table) {
        if(table[n] == -1){
            if(n <= 1)
                table[n] = n;
            else{
                table[n] = fibonacci(n-1,table) + fibonacci(n-2,table);
            }

        }
        return table[n];
    }
}
