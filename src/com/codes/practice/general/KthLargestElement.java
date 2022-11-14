package com.ford.practice.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KthLargestElement {

    private static int kthLargestElement(Integer[] arr,int k){
        List<Integer> list = Arrays.asList(arr);
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,7,9,1,3,6};
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println(k+"th largest element is: "+kthLargestElement(arr,k));
    }
}
