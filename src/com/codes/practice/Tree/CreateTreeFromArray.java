package com.ford.practice.Tree;

public class CreateTreeFromArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        BinarySearchTree root = createTreeFromArray(arr,0,arr.length-1);
        root.inOrder(root);
    }

    private static BinarySearchTree createTreeFromArray(int[] arr, int start, int end) {
        if(start > end)
            return null;
        int mid = (start+end)/2;
        BinarySearchTree root = new BinarySearchTree(arr[mid]);
        root.setLeftNode(createTreeFromArray(arr,start,mid-1));
        root.setRightNode(createTreeFromArray(arr,mid+1,end));
        return root;
    }
}
