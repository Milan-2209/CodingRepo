package com.ford.practice.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeftViewTree {
    public static void leftViewOfTree(BinarySearchTree root){
        Queue<BinarySearchTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=1;i<=size;i++){
                BinarySearchTree current = queue.remove();
                if(i==1)
                    System.out.println(current.getData());
                if(current.getLeftNode()!=null)
                    queue.add(current.getLeftNode());
                if(current.getRightNode()!=null)
                    queue.add(current.getRightNode());
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(20);
        root = root.insertNode(10,root);
        root = root.insertNode(28,root);
        root = root.insertNode(4,root);
        root = root.insertNode(12,root);
        root = root.insertNode(24,root);
        root = root.insertNode(30,root);
        root = root.insertNode(2,root);
        root = root.insertNode(11,root);
        root = root.insertNode(13,root);
        root = root.insertNode(1,root);
        leftViewOfTree(root);

    }
}
