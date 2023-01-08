package src.com.codes.practice.leetcode_solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTwoNumbers {
    public ListNode head = null;
    public ListNode tail = null;
    AddTwoNumbers a = new AddTwoNumbers();

    public static void main(String[] args) {
//        List<Integer> firstNumber = new ArrayList<>(){{add(9);add(9);add(9);add(9);add(9);add(9);add(9);add(9);}};
//        List<Integer> secondNumber = new ArrayList<>(){{add(9);add(9);add(9);add(9);}};
//        List<Integer> result = addTwoNums(firstNumber,secondNumber);
        Scanner sc = new Scanner(System.in);
        AddTwoNumbers a = new AddTwoNumbers();
//        ListNode l1 = null;
//        ListNode tail1 = null;
//        for(int i=0;i<3;i++) {
//            l1 = a.addNode(sc.nextInt(),l1);
//        }
//        while(l1 != null){
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }

        System.out.println("------------------------------------------------");

//        ListNode l2 = null;
//        ListNode tail2 = null;
//        for(int i=0;i<3;i++){
//            l2 = a.addNode(sc.nextInt(),l2,tail2);
//        }
//        while(l2 != null){
//            System.out.println(l2.val);
//            l2 = l2.next;
//        }

    }

    private static List<Integer> addTwoNums(List<Integer> firstNumber, List<Integer> secondNumber) {
        int firstNum = 0;
        int secondNum = 0;
        List<Integer> sumRes = new ArrayList<>();
        for(int a: firstNumber){
            firstNum = firstNum * 10 + a;
        }
        System.out.println(firstNum);
        for(int b: secondNumber){
            secondNum = secondNum * 10 + b;
        }
        System.out.println(secondNum);
        int sum = firstNum + secondNum;
        if(sum == 0)
            sumRes.add(0);
        while(sum > 0){
            sumRes.add(sum % 10);
            sum/=10;
        }
        return sumRes;
    }

    private ListNode addTwoNums(ListNode l1,ListNode l2){
        int firstNum = 0;
        int secondNum = 0;
        while(l1 != null){
            firstNum = firstNum * 10 + l1.val;
            l1 = l1.next;
        }
        while(l2 != null){
            secondNum = secondNum * 10 + l2.val;
            l2 = l2.next;
        }
        int sum = firstNum + secondNum;
        while(sum > 0){
            a.addNode(sum % 10);
            sum/=10;
        }

        return head;
    }

    public void addNode(int data) {
        ListNode tail = null;
        ListNode newNode = new ListNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
