package src.com.codes.practice.GreedyAlgos;

import java.util.ArrayList;
import java.util.Stack;

//Given three stacks of positive numbers, the task is to find the possible equal maximum sum of the stacks
//with removal of top elements allowed.

public class StacksEqualMaxSum {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.addAll(new ArrayList<>(){{add(1);add(1);add(1);add(2);add(3);}});
        Stack<Integer> stack2 = new Stack<>();
        stack2.addAll(new ArrayList<>(){{add(2);add(3);add(4);}});
        Stack<Integer> stack3 = new Stack<>();
        stack3.addAll(new ArrayList<>(){{add(1);add(4);add(5);}});
        System.out.println("Equal Max sum of the stacks: "+equalMaxSum(stack1,stack2,stack3));
    }

    private static int equalMaxSum(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        int sum1 = calculateSumOfStack(stack1);
        int sum2 = calculateSumOfStack(stack2);
        int sum3 = calculateSumOfStack(stack3);
        if(maxSum(sum1,sum2,sum3) == -1)
            return sum1;
        if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty())
            return 0;
        while(!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()){
            boolean flag = false;
            int max = maxSum(sum1,sum2,sum3);
            if(max==-1)
                return sum1;
            if(max == sum1 && !flag){
                stack1.pop();
                sum1 = calculateSumOfStack(stack1);
                flag = true;
            }
            if(max == sum2 && !flag){
                stack2.pop();
                sum2 = calculateSumOfStack(stack2);
                flag = true;
            }
            if(max == sum3 && !flag){
                stack3.pop();
                sum3 = calculateSumOfStack(stack3);
                flag = true;
            }
        }
        return 0;
    }

    private static int calculateSumOfStack(Stack<Integer> s){
        int sum = 0;
        for(int i=0;i<s.size();i++){
            sum+=s.get(i);
        }
        return sum;
    }

    private static int maxSum(int a,int b,int c){
        if(a==b && b==c)
            return -1;
        if(a > b){
            if(a > c)
                return a;
            else
                return c;
        }
        else{
            if(b > c)
                return b;
            else
                return c;
        }
    }
}

