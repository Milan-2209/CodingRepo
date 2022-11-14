package com.ford.practice.Tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTreeFromPreInOrder {

    public static void main(String[] args) {
        int[] preOrder = {10,6,4,7,11,12};
        int[] inOrder = {4,6,7,10,11,12};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i< inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        System.out.println(map);
        BinarySearchTree root = createTreeFromPreInorder(0,map,0,inOrder.length-1,preOrder);
        root.inOrder(root);
    }

    private static BinarySearchTree createTreeFromPreInorder(int pre_indx,Map<Integer, Integer> map, int start, int end, int[] preOrder) {
        if( start > end)
            return null;
        BinarySearchTree root = new BinarySearchTree(preOrder[pre_indx]);
        int indx = map.get(preOrder[pre_indx]);
        pre_indx++;
        root.setLeftNode(createTreeFromPreInorder(pre_indx,map,start,indx-1,preOrder));
        root.setRightNode(createTreeFromPreInorder(pre_indx,map,indx+1,end,preOrder));
        return root;
    }
}
