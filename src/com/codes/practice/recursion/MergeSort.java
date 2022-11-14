package com.ford.practice.recursion;

public class MergeSort {

    private static void mergeSort(int[] arr,int start,int end){
        if(start == end)
            return;
        int mid = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,end,mid);
    }

    private static void merge(int[] arr,int start,int end,int mid){
        int[] temp = new int[arr.length];
        int i = start;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                k++;
                i++;
            }
            else{
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while(i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j <= end){
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i=start;i<=end;i++){
            arr[i]=temp[i-start];
        }

    }
    private static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,2,3,8,7,9};
        System.out.println("Before Sorting: ");
        printArray(arr);
        mergeSort(arr,0, arr.length-1);
        System.out.println("After Sorting: ");
        printArray(arr);
    }
}
