package com.ford.practice.Tree;

import java.util.*;

import static java.lang.Math.max;

public class HeightOfTree {

    private static int heightOfTree(BinarySearchTree root){
        if(root==null)
            return 0;
        int left = heightOfTree(root.getLeftNode());
        int right = heightOfTree(root.getRightNode());
        return 1 + max(left,right);
    }

    private static int heightOfTreeUsingBFS(BinarySearchTree root){
        Queue<BinarySearchTree> queue = new LinkedList<>();
        queue.add(root);
        Map<Integer,Integer> visited = new HashMap<>();
        visited.put(root.getData(),1);
        while (!queue.isEmpty()){
            BinarySearchTree curr = queue.remove();
            int count = visited.get(curr.getData());
            if(curr.getLeftNode()!=null){
                visited.put(curr.getLeftNode().getData(),count+1);
                queue.add(curr.getLeftNode());
            }
            if(curr.getRightNode()!=null){
                visited.put(curr.getRightNode().getData(),count+1);
                queue.add(curr.getRightNode());
            }

        }
        System.out.println(visited);
        int height = Collections.max(visited.values());
        return height;
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
        System.out.println("Height of the Tree: "+heightOfTreeUsingBFS(root));
        System.out.println("Height of the Tree: "+heightOfTree(root));

    }
}
