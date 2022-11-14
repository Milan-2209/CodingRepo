package com.ford.practice.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {

    private static int binarySearch(List<Integer> arr, int start, int end, int item){
        if(start > end)
            return -1;
        else{
            int mid = (start+end)/2;
            if(arr.get(mid)==item){
                return mid;
            }
            else if(item < arr.get(mid))
                return binarySearch(arr,start,mid-1,item);
            else
               return binarySearch(arr,mid+1,end,item);
        }
    }


    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(7);
        arr.add(1);
        arr.add(6);
        arr.add(8);
        List<Integer> finalArr = arr.stream().sorted().collect(Collectors.toList());
        System.out.println(finalArr);
        int res = binarySearch(finalArr,0,arr.size()-1,9);
        if(res >= 0)
            System.out.println("Element found at position: "+(res+1));
        else
            System.out.println("Element not found");
    }
}
